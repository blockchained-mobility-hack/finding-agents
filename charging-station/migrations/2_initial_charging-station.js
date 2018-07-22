var MyChargingStation = artifacts.require("./MyChargingStation.sol");

module.exports = function(deployer) {
  deployer.deploy(MyChargingStation, "48.589728, 9.305515", "Type2", "NQQRBE9IJFYYHGKKEXWIIAVRGETUDQJPHVHSJTCRGJMKMGYJXYFFQKSCHO9QAGXXWX9IMITXNK99ELOSX");
};
