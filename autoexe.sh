#!/bin/sh

cd tsweb
mvn clean install

cd ../tsweb-main
mvn jetty:run

cd ..
