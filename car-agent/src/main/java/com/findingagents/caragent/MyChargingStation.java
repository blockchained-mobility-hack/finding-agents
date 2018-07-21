package com.findingagents.caragent;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes4;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class MyChargingStation extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b5060405161077d38038061077d833981018060405281019080805182019291906020018051820192919050505060016000806301ffc9a77c0100000000000000000000000000000000000000000000000000000000027bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200190815260200160002060006101000a81548160ff0219169083151502179055506001600080634e411af77c01000000000000000000000000000000000000000000000000000000000263f3cf09747c010000000000000000000000000000000000000000000000000000000002187bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200190815260200160002060006101000a81548160ff02191690831515021790555081600190805190602001906101909291906101af565b5080600290805190602001906101a79291906101af565b505050610254565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106101f057805160ff191683800117855561021e565b8280016001018555821561021e579182015b8281111561021d578251825591602001919060010190610202565b5b50905061022b919061022f565b5090565b61025191905b8082111561024d576000816000905550600101610235565b5090565b90565b61051a806102636000396000f30060806040526004361061006d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806301ffc9a7146100725780633c24223d146100d65780634e411af71461013f578063f3cf0974146101cf578063f563e77a1461025f575b600080fd5b34801561007e57600080fd5b506100bc60048036038101908080357bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191690602001909291905050506102c8565b604051808215151515815260200191505060405180910390f35b3480156100e257600080fd5b506100eb61032f565b60405180827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200191505060405180910390f35b34801561014b57600080fd5b5061015461035a565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610194578082015181840152602081019050610179565b50505050905090810190601f1680156101c15780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156101db57600080fd5b506101e46103fc565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610224578082015181840152602081019050610209565b50505050905090810190601f1680156102515780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561026b57600080fd5b5061027461049e565b60405180827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200191505060405180910390f35b6000806000837bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200190815260200160002060009054906101000a900460ff169050919050565b60006301ffc9a77c010000000000000000000000000000000000000000000000000000000002905090565b606060018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103f25780601f106103c7576101008083540402835291602001916103f2565b820191906000526020600020905b8154815290600101906020018083116103d557829003601f168201915b5050505050905090565b606060028054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104945780601f1061046957610100808354040283529160200191610494565b820191906000526020600020905b81548152906001019060200180831161047757829003601f168201915b5050505050905090565b6000634e411af77c01000000000000000000000000000000000000000000000000000000000263f3cf09747c010000000000000000000000000000000000000000000000000000000002189050905600a165627a7a72305820a1f8afc4a495428f4226d288679b23933a8dbc56ebcf1869c21263f008aa26dc0029";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_GETERC165MAPPINGIMPLEMENTATIONINTERFACEID = "getERC165MappingImplementationInterfaceId";

    public static final String FUNC_GETCHARGINGSTATIONINTERFACEID = "getChargingStationInterfaceId";

    public static final String FUNC_GETGEOLOCATION = "getGeoLocation";

    public static final String FUNC_GETPLUGTYPE = "getPlugType";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0xccdbab6f3f7e57886b36db971762b66152a3c1a6");
    }

    protected MyChargingStation(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MyChargingStation(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Bool> supportsInterface(Bytes4 interfaceID) {
        final Function function = new Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(interfaceID), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bytes4> getERC165MappingImplementationInterfaceId() {
        final Function function = new Function(FUNC_GETERC165MAPPINGIMPLEMENTATIONINTERFACEID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes4>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public static RemoteCall<MyChargingStation> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Utf8String _geoLocation, Utf8String _plugType) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_geoLocation, _plugType));
        return deployRemoteCall(MyChargingStation.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<MyChargingStation> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Utf8String _geoLocation, Utf8String _plugType) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_geoLocation, _plugType));
        return deployRemoteCall(MyChargingStation.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public RemoteCall<Bytes4> getChargingStationInterfaceId() {
        final Function function = new Function(FUNC_GETCHARGINGSTATIONINTERFACEID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes4>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Utf8String> getGeoLocation() {
        final Function function = new Function(FUNC_GETGEOLOCATION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Utf8String> getPlugType() {
        final Function function = new Function(FUNC_GETPLUGTYPE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public static MyChargingStation load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyChargingStation(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static MyChargingStation load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyChargingStation(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
