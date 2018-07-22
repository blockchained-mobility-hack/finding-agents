package com.findingagents.caragent;

import org.web3j.crypto.Hash;
import org.web3j.utils.Numeric;

public class ERC165Util {

    public static String erc165Hash(String ... functions) {
        byte[] magicBytes = {0, 0, 0, 0};
        byte[] functionSelectorBytes = new byte[4];

        for(int i = 0; i < functions.length; i++) {
            System.arraycopy(Hash.sha3(functions[i].getBytes()), 0, functionSelectorBytes, 0, 4);
            for(int j = 0; j < 4; j++){
                magicBytes[j] = (byte) (magicBytes[j] ^ functionSelectorBytes[j]);
            }
        }
        return Numeric.toHexString(magicBytes);
    }
}
