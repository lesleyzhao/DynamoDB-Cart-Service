#!/bin/bash
set -x

awslocal dynamodb create-table \
    --table-name cart-table \
    --attribute-definitions AttributeName=cartId,AttributeType=S \
    --key-schema AttributeName=cartId,KeyType=HASH \
    --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5
set +x