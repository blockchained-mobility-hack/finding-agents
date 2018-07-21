var MyChargingStation = artifacts.require("./MyChargingStation.sol");

module.exports = function(deployer) {
  deployer.deploy(MyChargingStation, "52.555555,13.454545", "Type2", process.env.IOTA_ADDRESS);
};
