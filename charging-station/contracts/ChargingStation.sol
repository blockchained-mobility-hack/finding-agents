pragma solidity ^0.4.24;

contract MyChargingStation is ChargingStation {

    string public message;

    function getMessage() public pure returns (string) {
        return 'howdy';
    }
}

interface ChargingStation {

    function getPlugType();

}