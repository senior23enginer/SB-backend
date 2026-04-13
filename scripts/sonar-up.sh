#!/usr/bin/env bash
set -euo pipefail

echo "[sonar] Levantando SonarQube + PostgreSQL..."
docker compose -f docker/sonarqube/docker-compose.yml up -d
bash ./scripts/wait-sonarqube.sh
echo "[sonar] SonarQube listo en http://localhost:9000"
