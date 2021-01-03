#!/bin/bash

echo "Visit this service on localhost:80"
docker run --network="bridge" -p 80:8080 sb-rest

