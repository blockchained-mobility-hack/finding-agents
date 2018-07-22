var MyChargingStation = artifacts.require("./MyChargingStation.sol");

module.exports = function(deployer) {
  deployer.deploy(MyChargingStation, "38.473639,-82.637583", "Type2", "NQQRBE9IJFYYHGKKEXWIIAVRGETUDQJPHVHSJTCRGJMKMGYJXYFFQKSCHO9QAGXXWX9IMITXNK99ELOSX");
};
