#!/bin/bash

while ! nc -z localhost 8888; do
    echo "Waiting for the Config Server"
    sleep 3
done

while ! nc -z localhost 8761; do
    echo "Waiting for the Discovery Server"
    sleep 3
done

java -jar auth-1.0-SNAPSHOT.jar