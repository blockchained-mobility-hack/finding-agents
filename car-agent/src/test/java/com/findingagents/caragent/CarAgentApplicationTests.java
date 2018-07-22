package com.findingagents.caragent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.web3j.crypto.Hash;
import org.web3j.utils.Numeric;

@Slf4j
public class CarAgentApplicationTests {

    @Test
    public void generateHashes() {

        byte[] magicBytes = new byte[4];
        System.arraycopy(Hash.sha3("supportsInterface(bytes4)".getBytes()), 0, magicBytes, 0, 4);

        log.info(Numeric.toHexString(magicBytes));

        // -----------

        byte[] plugTypeBytes = new byte[4];
        System.arraycopy(Hash.sha3("getPlugType()".getBytes()), 0, plugTypeBytes, 0, 4);

        byte[] geoLocationBytes = new byte[4];
        System.arraycopy(Hash.sha3("getGeoLocation()".getBytes()), 0, geoLocationBytes, 0, 4);

        magicBytes = new byte[4];
        for(int i = 0; i < 4; i++){
            magicBytes[i] = (byte) (plugTypeBytes[i] ^ geoLocationBytes[i]);
        }

        log.info(Numeric.toHexString(magicBytes));
    }

}
