#!/usr/bin/env bash

mvn package

docker build -t user-edge-service:latest .

docker run -it user-edge-service:latest --redis.address=LOCAL-PRIVATE-IP