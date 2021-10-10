#!/bin/bash
cur_dir=`pwd`
docker stop some-mysql
docker rm some-mysql
docker run --name some-mysql -v ${cur_dir}/conf:/etc/mysql/conf.d -v ${cur_dir}/data:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -d mysql:5.7