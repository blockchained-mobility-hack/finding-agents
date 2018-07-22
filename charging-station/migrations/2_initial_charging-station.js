var MyChargingStation = artifacts.require("./MyChargingStation.sol");

module.exports = function(deployer) {
  deployer.deploy(MyChargingStation, "52.015480,8.538084", "Type2", process.env.IOTA_ADDRESS);
};
