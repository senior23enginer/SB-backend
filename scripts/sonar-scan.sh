#!/usr/bin/env bash
set -euo pipefail

SONAR_HOST_URL="${SONAR_HOST_URL:-http://localhost:9000}"
SONAR_PROJECT_KEY="${SONAR_PROJECT_KEY:-sb-backend}"

bash ./scripts/wait-sonarqube.sh

echo "[sonar] Ejecutando analisis contra ${SONAR_HOST_URL}..."

if [ -n "${SONAR_TOKEN:-}" ]; then
  ./mvnw -DskipTests verify sonar:sonar \
    -Dsonar.host.url="${SONAR_HOST_URL}" \
    -Dsonar.projectKey="${SONAR_PROJECT_KEY}" \
    -Dsonar.token="${SONAR_TOKEN}"
else
  SONAR_USER="${SONAR_USER:-admin}"
  SONAR_PASSWORD="${SONAR_PASSWORD:-admin}"
  echo "[sonar] Aviso: no hay SONAR_TOKEN, se usara usuario/password (${SONAR_USER})."
  ./mvnw -DskipTests verify sonar:sonar \
    -Dsonar.host.url="${SONAR_HOST_URL}" \
    -Dsonar.projectKey="${SONAR_PROJECT_KEY}" \
    -Dsonar.login="${SONAR_USER}" \
    -Dsonar.password="${SONAR_PASSWORD}"
fi

echo "[sonar] Analisis enviado. Revisa resultados en ${SONAR_HOST_URL}."
