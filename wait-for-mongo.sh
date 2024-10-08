#!/bin/bash
until nc -z -v -w30 mongo 27017
do
  echo "Waiting for MongoDB connection..."
  sleep 5
done
echo "MongoDB is up and running"
exec "$@"


# Make the script executable:
# chmod +x wait-for-mongo.sh