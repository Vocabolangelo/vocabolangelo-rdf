#!/bin/bash

git clone https://github.com/stardog-union/pellet.git build/pellet
curl https://dlcdn.apache.org/jena/binaries/apache-jena-4.6.1.zip --output build/jena.zip
unzip -n -q -d build/jena build/jena.zip
cd ./build/pellet
mvn install -pl cli -DskipTests
chmod u+x ./cli/target/pelletcli/bin/pellet
cd ../..
./build/pellet/cli/target/pelletcli/bin/pellet extract _data/vocabolangelo.ttl >> _data/vocabolangelo-inferred.xml
./build/jena/apache-jena-4.6.1/bin/riot --output TURTLE _data/vocabolangelo.ttl _data/vocabolangelo-inferred.xml >> _data/vocabolangelo-merged.ttl
