#!/usr/bin/env bash

docker run \
    --name postgres \
    --network postgres-network \
    -v /tmp/pgdata:/var/lib/postgresql/data \
    -e POSTGRES_PASSWORD=password \
    -p 5432:5432 \
    -d \
    postgres