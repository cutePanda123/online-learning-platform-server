#!/usr/bin/env bash
docker run -v "$PWD:/data" thrift thrift -o /data --gen java /data/user_service.thrift