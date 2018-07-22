pragma solidity ^0.4.24;

interface ChargingStation {

    function getPlugType() external pure returns (string);

    function getGeoLocation() external pure returns(string);
    
    function getIotaAddress() external pure returns(string);
}
