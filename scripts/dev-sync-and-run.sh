#!/usr/bin/env bash
set -euo pipefail

if [ -n "${SKIP_GIT_PULL:-}" ]; then
  echo "[dev] SKIP_GIT_PULL activo: se omite git pull."
else
  if ! git diff --quiet || ! git diff --cached --quiet; then
    echo "[dev] Hay cambios locales sin commit. Para evitar conflictos se cancela git pull."
    echo "[dev] Opciones:"
    echo "      1) Commit/Stash y vuelve a correr el script"
    echo "      2) Ejecuta con SKIP_GIT_PULL=1 para iniciar sin actualizar"
    exit 1
  fi

  current_branch="$(git rev-parse --abbrev-ref HEAD)"
  echo "[dev] Actualizando rama ${current_branch} con ff-only..."
  git pull --ff-only origin "${current_branch}"
fi

echo "[dev] Levantando Oracle..."
docker compose -f docker/oracle/docker-compose.yml up -d

echo "[dev] Iniciando backend en modo desarrollo (Spring Boot)..."
./mvnw spring-boot:run
