var HDWalletProvider = require("truffle-hdwallet-provider");

var mnemonic = "feel oval about festival real help hawk interest mixture fossil magnet cup";

module.exports = {
    networks: {
        development: {
            host: 'localhost',
            port: 8545,
            network_id: '*'
        },
        ddf: {
            provider: function() {
              return new HDWalletProvider(mnemonic, "https://ropsten.infura.io/");
            },
            network_id: '3',
            gas: 4712388
        }
    }

};
