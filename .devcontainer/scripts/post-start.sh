#!/usr/bin/env bash
set -euo pipefail

echo "[devcontainer] Auto-sync de git..."
bash .devcontainer/scripts/auto-git-sync.sh

echo "[devcontainer] Levantando infraestructura local (Oracle + SonarQube)..."
bash ./scripts/infra-up.sh

echo "[devcontainer] Oracle disponible en localhost:1521."
echo "[devcontainer] SonarQube disponible en localhost:9000."
echo "[devcontainer] Para levantar el backend: ./scripts/dev-sync-and-run.sh"
