var HDWalletProvider = require("truffle-hdwallet-provider");

var mnemonic = "review fine deal citizen expand truck mother tobacco carpet crystal promote try";

module.exports = {
    networks: {
        development: {
            host: 'localhost',
            port: 8545,
            network_id: '*'
        },
        ddf: {
            provider: new HDWalletProvider(mnemonic, "https://rinkeby.infura.io/v3/fdd6f6ca0a29462e9e61ec616b8b07d9"),
            network_id: 4
        }
    }

};
