============================================================
GUIA RAPIDA PARA DEV FRONT - SB BACKEND
============================================================

Si solo necesitas levantar este backend para probar tu frontend,
esta guia es para ti.

No necesitas conocer todo el proyecto Java. Con los pasos de abajo
deberias poder correr la API localmente sin pelearte con el entorno.


------------------------------------------------------------
1) QUE NECESITAS INSTALADO
------------------------------------------------------------

- VS Code
- Extension "Dev Containers" en VS Code
- Docker Desktop encendido


------------------------------------------------------------
2) FORMA RECOMENDADA (DEV CONTAINER)
------------------------------------------------------------

1. Abre este repo en VS Code.
2. Ejecuta: "Dev Containers: Reopen in Container".
3. Cuando abra la terminal dentro del container, corre:

   ./scripts/dev-sync-and-run.sh

Ese comando hace 3 cosas:

- Baja cambios del repo con `git pull --ff-only` (si tu rama esta limpia).
- Levanta Oracle en Docker.
- Arranca el backend con Spring Boot.

Backend local:
- URL base: http://localhost:8080
- Swagger:  http://localhost:8080/swagger-ui.html


------------------------------------------------------------
3) SI YA TIENES CAMBIOS LOCALES
------------------------------------------------------------

Si estas trabajando en una rama con cambios sin commit, el script evita
hacer pull para no pisarte nada.

En ese caso puedes correr:

   SKIP_GIT_PULL=1 ./scripts/dev-sync-and-run.sh


------------------------------------------------------------
4) ATAJOS EN VS CODE (RUN TASK)
------------------------------------------------------------

Tambien tienes tareas listas en VS Code:

- Backend: Sync + Run
- Backend: Run (skip pull)
- Infra: Start Oracle

Ruta: Terminal > Run Task


------------------------------------------------------------
5) AUTO-ACTUALIZACION AL INICIAR CONTAINER
------------------------------------------------------------

Cada vez que inicias el Dev Container:

- Se revisa si hay cambios nuevos en remoto.
- Si todo esta limpio y solo vas atrasado, se hace pull automatico.
- Si hay cambios locales o rama divergente, no hace pull (por seguridad).

Si quieres desactivar eso:

- Edita `.devcontainer/devcontainer.json`
- Cambia `AUTO_GIT_SYNC_ON_START` a `"0"`


------------------------------------------------------------
6) PROBLEMAS COMUNES (RAPIDO)
------------------------------------------------------------

Problema: "No se pudo hacer fetch/pull"
- Revisa conexion a internet.
- Revisa permisos/credenciales de git en tu entorno.

Problema: "Oracle no levanta"
- Verifica Docker Desktop encendido.
- Revisa puertos ocupados (1521 y 5500).
- Reinicia Docker y vuelve a correr el script.

Problema: "El backend no arranca"
- Mira logs en la terminal donde corriste el script.
- Confirma que Oracle este arriba:
  docker compose -f docker/oracle/docker-compose.yml ps


------------------------------------------------------------
7) COMANDOS UTILES
------------------------------------------------------------

Levantar todo (recomendado):
  ./scripts/dev-sync-and-run.sh

Levantar sin pull:
  SKIP_GIT_PULL=1 ./scripts/dev-sync-and-run.sh

Solo Oracle:
  docker compose -f docker/oracle/docker-compose.yml up -d

Parar Oracle:
  docker compose -f docker/oracle/docker-compose.yml down


------------------------------------------------------------
NOTA FINAL
------------------------------------------------------------

Si algo no te corre en 5-10 minutos, no te quedes bloqueado/a:
comparte el error en el equipo y lo vemos juntos.

============================================================
