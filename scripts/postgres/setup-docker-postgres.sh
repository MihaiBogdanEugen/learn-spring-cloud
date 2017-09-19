#!/usr/bin/env bash

docker pull postgres

docker network create --driver bridge postgres-network

mkdir -p /tmp/pgdata