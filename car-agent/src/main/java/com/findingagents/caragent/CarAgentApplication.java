package com.findingagents.caragent;

import com.findingagents.caragent.model.ChargingStationModel;
import com.findingagents.caragent.model.ChargingStationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

    private static final String CHARGING_STATION_INTERFACE = "0xbd8e1383";
    private static final String ERC165_INTERFACE = "0x01ffc9a7";

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

    ApplicationRunner testMagic(Web3j web3j, Credentials credentials, ChargingStationRepository chargingStationRepository) {
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
                 .filter(address -> {
                     ERC165 contract = ERC165.load(address, web3j, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
                     try {
                         return contract.supportsInterface(new Bytes4(Numeric.hexStringToByteArray(CHARGING_STATION_INTERFACE))).send().getValue();
                     } catch (Exception e) {
                         return false;
                     }
                 })
                 .subscribe(addr -> {
                     try {
                         ChargingStation chargingStation = ChargingStation.load(addr, web3j, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);

                         ChargingStationModel model = ChargingStationModel.builder()
                                                                          .id(UUID.randomUUID().toString())
                                                                          .latitude(Double.valueOf(chargingStation.getGeoLocation().send().getValue().split(",")[0]))
                                                                          .longitude(Double.valueOf(chargingStation.getGeoLocation().send().getValue().split(",")[1]))
                                                                          .build();

                         log.info("saving: " + model.toString());
                         chargingStationRepository.save(model);

                     } catch (Exception e) {
                         log.error(e.getMessage());

                     }
                 });
        };
    }


}
