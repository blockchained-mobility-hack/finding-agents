var MyChargingStation = artifacts.require("./MyChargingStation.sol");

module.exports = function(deployer) {
  deployer.deploy(MyChargingStation, "51.0000000,8.0000000", "Type2");
};
