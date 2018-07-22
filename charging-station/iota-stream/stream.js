// Require the use of IOTA library
const IOTA = require("iota.lib.js")
const crypto = require('crypto')
// Create a new instance of the IOTA class object.
// Use 'provider' variable to specify which Full Node to talk to
const iota = new IOTA({provider: "https://nodes.testnet.iota.org:443"})

// Call the 'getNodeInfo call to check that the node is working
iota.api.getNodeInfo((error, success) => {
  if (error) {
    console.log(error)
  } else {
    console.log(success)
  }
})

const address = process.env.IOTA_ADDRESS

const message = iota.utils.toTrytes(JSON.stringify({
  status: process.env.STATUS,
  price: 45.00,
}))

const transfers = [{
  value: 0,
  address: address,
  message: message,
  tag: 'EMPTYBRAINS',
}]

iota.api.sendTransfer(address, 3, 9, transfers, (error, success) => {
  if (error) {
    console.log(error)
  } else {
    console.log(success)
  }
})
