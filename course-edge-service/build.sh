#!/usr/bin/env bash

mvn package

docker build -t course-edge-service:latest .

docker run -it course-edge-service:latest --zookeeper.address=LOCAL-PRIVATE-IP