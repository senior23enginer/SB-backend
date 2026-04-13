#!/usr/bin/env bash
set -euo pipefail

echo "[sonar] Apagando SonarQube + PostgreSQL..."
docker compose -f docker/sonarqube/docker-compose.yml down
echo "[sonar] Servicios detenidos."
