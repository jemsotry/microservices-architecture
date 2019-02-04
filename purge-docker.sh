#!/bin/bash
#docker rm product-cmd-side
#docker rm product-qry-side
#docker rm product-qry-side-1
#docker rm product-qry-side-2
#docker rm discovery
#docker rm rabbitmq
#docker rm mongodb
#docker rmi jemsotry/product-command-side:latest
#docker rmi jemsotry/product-query-side:latest
#docker rmi jemsotry/discovery-service:latest
#docker rmi $(docker images -f "dangling=true" -q)
docker rm -v $(docker ps -a -q -f status=exited)
docker rmi $(docker images -f "dangling=true" -q)
docker volume rm $(docker volume ls -qf dangling=true)
