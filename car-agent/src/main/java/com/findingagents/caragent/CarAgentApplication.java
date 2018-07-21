package com.findingagents.caragent;

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
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Numeric;
import rx.Observable;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.util.Collections;

@Slf4j
@SpringBootApplication
public class CarAgentApplication {

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

    @Bean
    ApplicationRunner moreFun(Web3j web3j, Credentials credentials) throws IOException {
        return args -> {
            // get contract address
            EthGetTransactionReceipt transactionReceipt =
                    web3j.ethGetTransactionReceipt("0xa14c0214bb8cabd91f6806e16803c0f42e3b392a5e6bbc8b2024e49c229011ed").send();

            log.info(transactionReceipt.getTransactionReceipt().get().getContractAddress());
        };
    }

    ApplicationRunner testMagic(Web3j web3j, Credentials credentials) {
        return args -> {


            web3j.transactionObservable()
                 .map(tx -> {
                     return tx.getTo();
                 })
                 .filter(contractAddress -> !contractAddress.equals("0x0"))
                 .map(contractAddress -> {
                     log.info("contract address: " + contractAddress);
                     return contractAddress;

                 })
                 .flatMap(addr -> {
                     try {
                         ERC165 contract = ERC165.load(addr, web3j, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
                         contract.supportsInterface(new Bytes4(Numeric.hexStringToByteArray("0xbd8e1383")))
                                               .observable().retry(5).subscribe(result -> log.info("MAGIC" + result.getValue()));

                         return Observable.just("ignore");

                     } catch (Exception e) {
                         log.error(e.getMessage());
                         return Observable.just("error");
                     }
                 })

                 .subscribe(
                         result -> log.info("MAGIC: " + result)
                 );

        };
    }

    public static String asciiToHex(String asciiValue)
    {
        char[] chars = asciiValue.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (char aChar : chars) {
            hex.append(Integer.toHexString((int) aChar));
        }

        return hex.toString() + "".join("", Collections.nCopies(32 - (hex.length()/2), "00"));
    }

    public static String bytes32ToAscii(Bytes4 bytes32) {

        return hexToASCII(DatatypeConverter.printHexBinary(bytes32.getValue()));
    }

    public static String hexToASCII(String hexValue) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < hexValue.length(); i += 2) {
            String str = hexValue.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }

        return output.toString();
    }
}
