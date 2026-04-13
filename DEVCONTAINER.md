# Dev Container para SB-backend

Este repositorio incluye configuracion para levantar un entorno de desarrollo reproducible con VS Code Dev Containers.

## Que hace automaticamente

- Instala entorno Java 21 + Maven dentro del contenedor.
- Expone puertos `8080` (backend), `9000` (SonarQube), `1521` y `5500` (Oracle).
- Al iniciar el contenedor:
  - Revisa si hay cambios remotos en la rama actual y hace `git pull --ff-only` cuando es seguro.
  - Levanta infraestructura completa (`Oracle + SonarQube`).
  - Espera a que Oracle quede `healthy` antes de continuar.
  - Deja extensiones HTTP Client listas para probar endpoints sin Postman.

## Flujo recomendado (dev front que necesita backend rapido)

1. Abrir el repositorio en VS Code.
2. Ejecutar `Dev Containers: Reopen in Container`.
3. En la terminal del contenedor, correr:

```bash
./scripts/dev-sync-and-run.sh
```

Este script:

- Hace `git pull --ff-only` de la rama actual (si no hay cambios locales).
- Levanta `Oracle + SonarQube` en Docker.
- Inicia Spring Boot con `./mvnw spring-boot:run`.

Si tienes cambios locales y no quieres hacer pull, usa:

```bash
SKIP_GIT_PULL=1 ./scripts/dev-sync-and-run.sh
```

Tambien puedes usar tareas de VS Code desde `Terminal > Run Task`:

- `Backend: Sync + Run`
- `Backend: Run (skip pull)`
- `Infra: Start (Oracle + SonarQube)`
- `Sonar: Start`
- `Sonar: Analyze`
- `Sonar: Stop`

## HTTP Client (tipo Postman)

En el Dev Container se instalan estas extensiones:

- `humao.rest-client`
- `rangav.vscode-thunder-client`

Archivo listo para pruebas:

- `curl/sb-backend.http`

## Auto-sync al iniciar

Por defecto esta activo (`AUTO_GIT_SYNC_ON_START=1` en `devcontainer.json`).

Reglas de seguridad del auto-sync:

- Si no hay cambios remotos, no hace nada.
- Si la rama local esta atrasada y limpia, hace `pull --ff-only`.
- Si hay cambios locales, rama divergente o `HEAD` detached, no hace pull.

Si quieres apagarlo, cambia en `devcontainer.json`:

```json
"remoteEnv": {
  "AUTO_GIT_SYNC_ON_START": "0"
}
```

## Requisitos en la maquina host

- Docker Desktop / Docker Engine
- VS Code + extension Dev Containers
