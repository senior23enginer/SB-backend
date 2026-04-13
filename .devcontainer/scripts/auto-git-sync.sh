#!/usr/bin/env bash
set -euo pipefail

AUTO_SYNC="${AUTO_GIT_SYNC_ON_START:-1}"
if [ "$AUTO_SYNC" != "1" ]; then
  echo "[devcontainer] AUTO_GIT_SYNC_ON_START=0, se omite auto-sync."
  exit 0
fi

if ! git rev-parse --is-inside-work-tree >/dev/null 2>&1; then
  echo "[devcontainer] No es un repositorio git. Se omite auto-sync."
  exit 0
fi

branch="$(git rev-parse --abbrev-ref HEAD 2>/dev/null || true)"
if [ -z "${branch}" ] || [ "${branch}" = "HEAD" ]; then
  echo "[devcontainer] HEAD detached. Se omite auto-sync."
  exit 0
fi

upstream_ref="@{u}"
if ! git rev-parse "${upstream_ref}" >/dev/null 2>&1; then
  if git rev-parse "origin/${branch}" >/dev/null 2>&1; then
    git branch --set-upstream-to="origin/${branch}" "${branch}" >/dev/null 2>&1 || true
  else
    echo "[devcontainer] No hay upstream para ${branch}. Se omite auto-sync."
    exit 0
  fi
fi

echo "[devcontainer] Revisando cambios remotos de ${branch}..."
if ! git fetch origin "${branch}" --prune; then
  echo "[devcontainer] No se pudo hacer fetch (credenciales/red). Se omite auto-sync."
  exit 0
fi

local_sha="$(git rev-parse @)"
remote_sha="$(git rev-parse "${upstream_ref}")"
base_sha="$(git merge-base @ "${upstream_ref}")"

if [ "${local_sha}" = "${remote_sha}" ]; then
  echo "[devcontainer] Repositorio actualizado."
  exit 0
fi

if [ "${local_sha}" = "${base_sha}" ]; then
  if ! git diff --quiet || ! git diff --cached --quiet; then
    echo "[devcontainer] Hay cambios locales. No se hace pull automatico."
    exit 0
  fi

  echo "[devcontainer] Hay cambios nuevos. Aplicando git pull --ff-only..."
  if git pull --ff-only origin "${branch}"; then
    echo "[devcontainer] Auto-sync completado."
  else
    echo "[devcontainer] Pull no aplicado. Revisa estado de git manualmente."
  fi
  exit 0
fi

if [ "${remote_sha}" = "${base_sha}" ]; then
  echo "[devcontainer] Tu rama local va adelantada. No se hace pull."
  exit 0
fi

echo "[devcontainer] Rama divergente con remoto. No se hace pull automatico."
