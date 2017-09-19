#!/usr/bin/env bash

docker run -d \
    --name rabbitmq \
    -e RABBITMQ_DEFAULT_USER=spring \
    -e RABBITMQ_DEFAULT_PASS=cloud \
    -p 4369:4369 \
    -p 5671:5671 \
    -p 5672:5672 \
    -p 15671:15671 \
    -p 15672:15672 \
    -p 25672:25672 \
    rabbitmq:management