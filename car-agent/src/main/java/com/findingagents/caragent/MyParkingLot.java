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
public class MyParkingLot extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b5060405161090138038061090183398101806040528101908080518201929190602001805182019291906020018051820192919050505060016000806301ffc9a77c0100000000000000000000000000000000000000000000000000000000027bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200190815260200160002060006101000a81548160ff02191690831515021790555060016000806398edcbd27c010000000000000000000000000000000000000000000000000000000002634e411af77c010000000000000000000000000000000000000000000000000000000002637a53e0407c01000000000000000000000000000000000000000000000000000000000218187bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200190815260200160002060006101000a81548160ff02191690831515021790555082600190805190602001906101bf9291906101f6565b5081600290805190602001906101d69291906101f6565b5080600390805190602001906101ed9291906101f6565b5050505061029b565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061023757805160ff1916838001178555610265565b82800160010185558215610265579182015b82811115610264578251825591602001919060010190610249565b5b5090506102729190610276565b5090565b61029891905b8082111561029457600081600090555060010161027c565b5090565b90565b610657806102aa6000396000f300608060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806301ffc9a71461007d5780633c24223d146100e15780634e411af71461014a5780637a53e040146101da57806398edcbd21461026a578063f563e77a146102fa575b600080fd5b34801561008957600080fd5b506100c760048036038101908080357bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19169060200190929190505050610363565b604051808215151515815260200191505060405180910390f35b3480156100ed57600080fd5b506100f66103ca565b60405180827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200191505060405180910390f35b34801561015657600080fd5b5061015f6103f5565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561019f578082015181840152602081019050610184565b50505050905090810190601f1680156101cc5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156101e657600080fd5b506101ef610497565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561022f578082015181840152602081019050610214565b50505050905090810190601f16801561025c5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561027657600080fd5b5061027f610539565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156102bf5780820151818401526020810190506102a4565b50505050905090810190601f1680156102ec5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561030657600080fd5b5061030f6105db565b60405180827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200191505060405180910390f35b6000806000837bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200190815260200160002060009054906101000a900460ff169050919050565b60006301ffc9a77c010000000000000000000000000000000000000000000000000000000002905090565b606060018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561048d5780601f106104625761010080835404028352916020019161048d565b820191906000526020600020905b81548152906001019060200180831161047057829003601f168201915b5050505050905090565b606060028054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561052f5780601f106105045761010080835404028352916020019161052f565b820191906000526020600020905b81548152906001019060200180831161051257829003601f168201915b5050505050905090565b606060038054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105d15780601f106105a6576101008083540402835291602001916105d1565b820191906000526020600020905b8154815290600101906020018083116105b457829003601f168201915b5050505050905090565b6000634e411af77c010000000000000000000000000000000000000000000000000000000002637a53e0407c010000000000000000000000000000000000000000000000000000000002189050905600a165627a7a72305820fad0f1f3c12b51f70cadbc01169eb7972e2ae8aa55a006301e498bf800982f850029";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_GETERC165MAPPINGIMPLEMENTATIONINTERFACEID = "getERC165MappingImplementationInterfaceId";

    public static final String FUNC_GETCHARGINGSTATIONINTERFACEID = "getChargingStationInterfaceId";

    public static final String FUNC_GETIOTAADDRESS = "getIotaAddress";

    public static final String FUNC_GETGEOLOCATION = "getGeoLocation";

    public static final String FUNC_GETAVAILABILITY = "getAvailability";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    protected MyParkingLot(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MyParkingLot(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
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

    public static RemoteCall<MyParkingLot> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Utf8String _geoLocation, Utf8String _availability, Utf8String _iotaAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_geoLocation, _availability, _iotaAddress));
        return deployRemoteCall(MyParkingLot.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<MyParkingLot> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Utf8String _geoLocation, Utf8String _availability, Utf8String _iotaAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_geoLocation, _availability, _iotaAddress));
        return deployRemoteCall(MyParkingLot.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public RemoteCall<Bytes4> getChargingStationInterfaceId() {
        final Function function = new Function(FUNC_GETCHARGINGSTATIONINTERFACEID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes4>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Utf8String> getIotaAddress() {
        final Function function = new Function(FUNC_GETIOTAADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Utf8String> getGeoLocation() {
        final Function function = new Function(FUNC_GETGEOLOCATION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Utf8String> getAvailability() {
        final Function function = new Function(FUNC_GETAVAILABILITY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public static MyParkingLot load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyParkingLot(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static MyParkingLot load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyParkingLot(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
