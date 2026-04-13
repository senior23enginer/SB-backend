#!/usr/bin/env bash
set -euo pipefail

echo "[devcontainer] Auto-sync de git..."
bash .devcontainer/scripts/auto-git-sync.sh

echo "[devcontainer] Levantando Oracle local..."
docker compose -f docker/oracle/docker-compose.yml up -d

echo "[devcontainer] Oracle disponible en localhost:1521."
echo "[devcontainer] Para levantar el backend: ./scripts/dev-sync-and-run.sh"
