pragma solidity ^0.4.24;

import "./ChargingStation.sol";
import "./ERC165MappingImplementation.sol";

contract MyChargingStation is ChargingStation, ERC165MappingImplementation {


    string private geoLocation;
    string private plugType;
    string private iotaAddress;

    constructor(string _geoLocation, string _plugType) public {
        supportedInterfaces[this.getPlugType.selector ^ this.getGeoLocation.selector ^ this.getIotaAddress.selector] = true;

        geoLocation = _geoLocation;
        plugType = _plugType;
        iotaAddress = _iotaAddress;
    }

    function getChargingStationInterfaceId() public view returns (bytes4){
        return (this.getPlugType.selector ^ this.getGeoLocation.selector);
    }

    function getIotaAddress() public view returns (string) {
        return iotaAddress;
    }

    function getGeoLocation() public view returns (string) {
        return geoLocation;
    }

    function getPlugType() public view returns (string) {
        return plugType;
    }


}
