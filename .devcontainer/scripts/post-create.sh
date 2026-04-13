#!/usr/bin/env bash
set -euo pipefail

if [ -f "./mvnw" ]; then
  chmod +x ./mvnw
fi

chmod +x ./scripts/*.sh || true
chmod +x ./.devcontainer/scripts/*.sh || true

echo "[devcontainer] Descargando dependencias Maven (si aplica)..."
if ! ./mvnw -q -DskipTests dependency:go-offline; then
  echo "[devcontainer] Aviso: no se pudo completar go-offline. Puedes continuar y ejecutar el backend manualmente."
fi
