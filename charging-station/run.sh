#!/bin/bash

cd iota-stream
export IOTA_ADDRESS=$(nodejs generateKey.js)
cd ..

rm -fr build; truffle migrate

cd iota-stream
STATUS=available  nodejs stream.js
read  -n 1
STATUS=charging nodejs stream.js



