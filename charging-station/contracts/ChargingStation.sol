pragma solidity ^0.4.24;

interface ChargingStation {

    function getPlugType() external returns (string);

    function getGeoLocation() external pure returns(string);
}