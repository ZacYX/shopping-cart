#!/bin/bash

# Exit immediately if a command exits with a non-zero status
set -e

# Check if the secret file exists
if [ -f /run/secrets/db_url ]; then
    # Read the secret and export it as an environment variable
    export DATABASE_URL=$(cat /run/secrets/db_url)
    echo "Secret loaded into DATABASE_URL"
else
    echo "Secret file not found, continuing without DATABASE_URL"
fi
if [ -f /run/secrets/db_user ]; then
    # Read the secret and export it as an environment variable
    export DATABASE_USER=$(cat /run/secrets/db_user)
    echo "Secret loaded into DATABASE_USER"
else
    echo "Secret file not found, continuing without DATABASE_USER"
fi
if [ -f /run/secrets/db_password ]; then
    # Read the secret and export it as an environment variable
    export DATABASE_PASSWORD=$(cat /run/secrets/db_password)
    echo "Secret loaded into DATABASE_PASSWORD"
else
    echo "Secret file not found, continuing without DATABASE_PASSWORD"
fi

# Execute the passed command
exec "$@"
