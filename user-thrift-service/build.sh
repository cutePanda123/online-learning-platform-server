#!/usr/bin/env bash

mvn package

docker build -t user-service:latest .

docker run -it user-service:latest --mysql.address=LOCAL-PRIVATE-IP