package com.findingagents.caragent;

import com.findingagents.caragent.model.ChargingStationModel;
import com.findingagents.caragent.model.ChargingStationRepository;
import com.findingagents.caragent.model.ParkingLotModel;
import com.findingagents.caragent.model.ParkingLotRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.generated.Bytes4;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@SpringBootApplication
public class CarAgentApplication {

    private static final String CHARGING_STATION_INTERFACE = ERC165Util.erc165Hash(
            "getPlugType()",
            "getGeoLocation()",
            "getIotaAddress()");

    private static final String ERC165_INTERFACE = ERC165Util.erc165Hash("supportsInterface(bytes4)");

    private static final String PARKING_LOT_INTERFACE = ERC165Util.erc165Hash("getAvailability()", "getGeoLocation()", "getIotaAddress()");

    public static void main(String[] args) {
        SpringApplication.run(CarAgentApplication.class, args);
    }

    ApplicationRunner getValues(Web3j web3j, Credentials credentials){
        return args -> {

            ERC165 contract = ERC165.load("0xa21C9FEDe72A87b63f2Bfb69e60Ce378Fc038D90", web3j, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
           Bool result = contract.supportsInterface(new Bytes4(Numeric.hexStringToByteArray("0xbd8e1383")))
                                .send();

           log.info("MAGIC: " + result.getValue());
        };
    }

    ApplicationRunner moreFun(Web3j web3j, Credentials credentials) throws IOException {
        return args -> {
            // get contract address
            EthGetTransactionReceipt transactionReceipt =
                    web3j.ethGetTransactionReceipt("0xa14c0214bb8cabd91f6806e16803c0f42e3b392a5e6bbc8b2024e49c229011ed").send();

            log.info(transactionReceipt.getTransactionReceipt().get().getContractAddress());
        };
    }

    @Bean
    ApplicationRunner testMagic(Web3j web3j, Credentials credentials, ChargingStationRepository chargingStationRepository, ParkingLotRepository parkingLotRepository) {
        return args -> {

            chargingStationRepository.deleteAll();

            web3j.transactionObservable()
                 .flatMap(tx -> web3j.ethGetTransactionReceipt(tx.getHash()).observable())
                 .map(receipt -> receipt.getTransactionReceipt().orElse(null))
                 .map(TransactionReceipt::getContractAddress)
                 .filter(address -> {
                     ERC165 contract = ERC165.load(address, web3j, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
                     try {
                         return contract.supportsInterface(new Bytes4(Numeric.hexStringToByteArray(ERC165_INTERFACE))).send().getValue();
                     } catch (Exception e) {
                        return false;
                     }
                 })
                 .subscribe(address -> {
                     ERC165 contract = ERC165.load(address, web3j, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
                     try {
                         if(contract.supportsInterface(new Bytes4(Numeric.hexStringToByteArray(CHARGING_STATION_INTERFACE))).send().getValue()){
                             ChargingStation chargingStation = ChargingStation.load(address, web3j, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);

                             ChargingStationModel model = ChargingStationModel.builder()
                                                                              .id(UUID.randomUUID().toString())
                                                                              .latitude(Double.valueOf(chargingStation.getGeoLocation().send().getValue().split(",")[0]))
                                                                              .longitude(Double.valueOf(chargingStation.getGeoLocation().send().getValue().split(",")[1]))
                                                                              .build();

                             log.info("saving: " + model.toString());
                             chargingStationRepository.save(model);
                         };

                         if(contract.supportsInterface(new Bytes4(Numeric.hexStringToByteArray(PARKING_LOT_INTERFACE))).send().getValue()){
                             ParkingLot parkingLot = ParkingLot.load(address, web3j, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);

                             ParkingLotModel model = ParkingLotModel.builder()
                                                                         .id(UUID.randomUUID().toString())
                                                                         .latitude(Double.valueOf(parkingLot.getGeoLocation().send().getValue().split(",")[0]))
                                                                         .longitude(Double.valueOf(parkingLot.getGeoLocation().send().getValue().split(",")[1]))
                                                                            .availability(parkingLot.getAvailability().send().getValue())
                                                                         .build();

                             log.info("saving: " + model.toString());
                             parkingLotRepository.save(model);
                         };
                     } catch (Exception e) {
                         log.error(e.getMessage());
                     }
                 });
        };
    }


}
