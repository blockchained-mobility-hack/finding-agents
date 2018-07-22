pragma solidity ^0.4.24;

import "./ParkingLot.sol";
import "./ERC165MappingImplementation.sol";

contract MyParkingLot is ParkingLot, ERC165MappingImplementation {


    string private geoLocation;
    string private availability;
    string private iotaAddress;

    constructor(string _geoLocation, string _availability, string _iotaAddress) public {
        supportedInterfaces[this.getAvailability.selector ^ this.getGeoLocation.selector ^ this.getIotaAddress.selector] = true;

        geoLocation = _geoLocation;
        availability = _availability;
        iotaAddress = _iotaAddress;
    }

    function getChargingStationInterfaceId() public view returns (bytes4){
        return (this.getAvailability.selector ^ this.getGeoLocation.selector);
    }

    function getIotaAddress() public view returns (string) {
        return iotaAddress;
    }

    function getGeoLocation() public view returns (string) {
        return geoLocation;
    }

    function getAvailability() public view returns (string) {
        return availability;
    }


}
