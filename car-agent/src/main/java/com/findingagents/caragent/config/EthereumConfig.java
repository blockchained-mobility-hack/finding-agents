package com.findingagents.caragent.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import java.io.IOException;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "evac.car-gateway.ethereum")
public class EthereumConfig {

    private String walletPassword;

    @Bean
    Credentials getWalletCredentials() throws IOException, CipherException {
        return WalletUtils.loadCredentials(walletPassword, ResourceUtils.getFile("classpath:wallet.json"));
    }

}
