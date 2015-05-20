#!/bin/sh

cd tsweb
mvn clean install
mvn deploy

cd ../tsweb-main
mvn tomcat7:redeploy

cd ..
