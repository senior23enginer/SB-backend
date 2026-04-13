#!/usr/bin/env bash
set -euo pipefail

SONAR_HOST_URL="${SONAR_HOST_URL:-http://localhost:9000}"
TIMEOUT_SECONDS="${SONAR_WAIT_TIMEOUT_SECONDS:-240}"
SLEEP_SECONDS=5

echo "[sonar] Esperando SonarQube en ${SONAR_HOST_URL} (timeout ${TIMEOUT_SECONDS}s)..."

elapsed=0
while true; do
  status="$(curl -sS "${SONAR_HOST_URL}/api/system/status" | sed -n 's/.*"status":"\([^"]*\)".*/\1/p' || true)"
  if [ "${status}" = "UP" ]; then
    echo "[sonar] SonarQube disponible (status=UP)."
    exit 0
  fi

  if [ "${elapsed}" -ge "${TIMEOUT_SECONDS}" ]; then
    echo "[sonar] Timeout esperando SonarQube."
    exit 1
  fi

  sleep "${SLEEP_SECONDS}"
  elapsed=$((elapsed + SLEEP_SECONDS))
done
