#!/bin/bash

mvn clean install spring-boot:repackage
docker build . --tag sb-rest
