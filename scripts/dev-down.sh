#!/usr/bin/env bash
set -euo pipefail

docker compose -f docker-compose.yaml -f docker-compose.dev.yml down "$@"
