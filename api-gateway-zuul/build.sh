#!/usr/bin/env bash

mvn package

docker build -t api-gateway-zuul:latest .

docker run -it api-gateway-zuul:latest --mysql.address=LOCAL-PRIVATE-IP