#!/usr/bin/env bash

# Start API Server
mvn tomcat7:redeploy > logs/apiserver.log 

echo 'Started API Server'

exit 0
