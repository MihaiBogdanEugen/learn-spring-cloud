#!/usr/bin/env bash

docker run \
    -it \
    --rm \
    --network postgres-network \
    postgres psql \
    -h postgres \
    -U postgres