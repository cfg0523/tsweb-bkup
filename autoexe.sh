#!/bin/sh

cd tsweb
mvn clean package install
mvn deploy

cd ../tsweb-main
mvn tomcat7:deploy

cd ..
