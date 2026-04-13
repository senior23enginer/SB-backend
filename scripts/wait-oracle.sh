#!/usr/bin/env bash
set -euo pipefail

ORACLE_COMPOSE_FILE="${ORACLE_COMPOSE_FILE:-docker/oracle/docker-compose.yml}"
ORACLE_SERVICE_NAME="${ORACLE_SERVICE_NAME:-oracle-free}"
TIMEOUT_SECONDS="${ORACLE_WAIT_TIMEOUT_SECONDS:-420}"
SLEEP_SECONDS=5

echo "[oracle] Esperando estado healthy de ${ORACLE_SERVICE_NAME} (timeout ${TIMEOUT_SECONDS}s)..."

container_id="$(docker compose -f "${ORACLE_COMPOSE_FILE}" ps -q "${ORACLE_SERVICE_NAME}")"
if [ -z "${container_id}" ]; then
  echo "[oracle] No se encontro container para ${ORACLE_SERVICE_NAME}."
  exit 1
fi

elapsed=0
while true; do
  health_status="$(docker inspect --format='{{if .State.Health}}{{.State.Health.Status}}{{else}}no-healthcheck{{end}}' "${container_id}" 2>/dev/null || true)"

  if [ "${health_status}" = "healthy" ]; then
    echo "[oracle] Oracle listo (healthy)."
    exit 0
  fi

  if [ "${health_status}" = "unhealthy" ]; then
    echo "[oracle] Oracle reporta unhealthy."
    exit 1
  fi

  if [ "${health_status}" = "no-healthcheck" ]; then
    echo "[oracle] El contenedor no tiene healthcheck configurado."
    exit 1
  fi

  if [ "${elapsed}" -ge "${TIMEOUT_SECONDS}" ]; then
    echo "[oracle] Timeout esperando Oracle healthy."
    exit 1
  fi

  sleep "${SLEEP_SECONDS}"
  elapsed=$((elapsed + SLEEP_SECONDS))
done
