package com.findingagents.caragent;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.web3j.protocol.Web3j;

@SpringBootApplication
public class CarAgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarAgentApplication.class, args);
    }


    @Bean
    ApplicationRunner testMagic(Web3j web3j) {
        return args -> {

        };
    }
}
