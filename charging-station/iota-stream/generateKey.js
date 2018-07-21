const crypto = require('crypto')

const keyGen = length => {
    const charset = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ9'
    var key = '';
    while (key.length < length) {
        var byte = crypto.randomBytes(1)
        if (byte[0] < 243) {
            key += charset.charAt(byte[0] % 27);
        }
    }
    return key;
}


const trytes = keyGen(80) + 'X'
console.log(trytes)
