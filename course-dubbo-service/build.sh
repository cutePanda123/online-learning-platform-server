#!/usr/bin/env bash

mvn package

docker build -t course-dubbo-service:latest .

docker run -it course-dubbo-service:latest --mysql.address=LOCAL-PRIVATE-IP