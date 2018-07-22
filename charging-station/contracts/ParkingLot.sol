pragma solidity ^0.4.24;

interface ParkingLot {

    function getAvailability external pure returns (string);

    function getGeoLocation() external pure returns(string);
    
    function getIotaAddress() external pure returns(string);
}
