#!/usr/bin/env bash
docker run -v "$PWD:/data" thrift thrift -o /data --gen py /data/message.thrift