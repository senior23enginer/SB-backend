#!/usr/bin/env bash
set -euo pipefail

echo "[infra] Levantando Oracle..."
docker compose -f docker/oracle/docker-compose.yml up -d
bash ./scripts/wait-oracle.sh

echo "[infra] Levantando SonarQube..."
docker compose -f docker/sonarqube/docker-compose.yml up -d

echo "[infra] Infraestructura lista (Oracle healthy + SonarQube en arranque)."
