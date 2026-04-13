============================================================
SB-BACKEND - DOCUMENTACION TECNICA DE ENTORNO LOCAL
============================================================

Estado del documento: vigente para setup local con Dev Container
Repositorio: SB-backend
Stack principal: Java 21, Spring Boot, Maven, Oracle, SonarQube


------------------------------------------------------------
1) OBJETIVO
------------------------------------------------------------

Estandarizar el entorno de desarrollo local para que cualquier perfil
(backend o frontend) pueda:

- levantar API local de forma reproducible,
- usar base Oracle local,
- ejecutar analisis de calidad con SonarQube,
- probar endpoints HTTP sin herramientas externas obligatorias.


------------------------------------------------------------
2) TOPOLOGIA LOCAL
------------------------------------------------------------

Componentes:

1. Dev Container (VS Code)
2. Spring Boot app (puerto 8080)
3. Oracle Free (puertos 1521 y 5500)
4. SonarQube Community + PostgreSQL (puerto 9000)

Flujo de arranque esperado:

1. Se abre el repo en Dev Container.
2. `postStart` ejecuta:
   - auto-sync git seguro (ff-only cuando aplica),
   - arranque de infraestructura (Oracle + SonarQube).
3. El backend se levanta manualmente con script de desarrollo.


------------------------------------------------------------
3) REQUISITOS DEL HOST
------------------------------------------------------------

- Docker Desktop / Docker Engine operativo.
- VS Code con extension Dev Containers.
- Acceso a git remoto (si se usara auto-sync de cambios).

No se requiere Java/Maven instalados en host para flujo recomendado.


------------------------------------------------------------
4) ESTRUCTURA DE CONFIGURACION
------------------------------------------------------------

Archivos de entorno:

- `.devcontainer/devcontainer.json`
- `.devcontainer/scripts/post-create.sh`
- `.devcontainer/scripts/post-start.sh`
- `.devcontainer/scripts/auto-git-sync.sh`

Infra Docker:

- `docker/oracle/docker-compose.yml`
- `docker/sonarqube/docker-compose.yml`

Scripts operativos:

- `scripts/dev-sync-and-run.sh`
- `scripts/infra-up.sh`
- `scripts/sonar-up.sh`
- `scripts/sonar-scan.sh`
- `scripts/sonar-down.sh`
- `scripts/wait-sonarqube.sh`

Cliente HTTP:

- `curl/sb-backend.http`
- `curl/butlos.txt` (comandos curl directos)


------------------------------------------------------------
5) PUERTOS Y ENDPOINTS DE SERVICIOS
------------------------------------------------------------

Puertos locales:

- 8080 -> Spring Boot API
- 9000 -> SonarQube UI/API
- 1521 -> Oracle listener
- 5500 -> Oracle management

URLs relevantes:

- API base: `http://localhost:8080`
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`
- SonarQube: `http://localhost:9000`


------------------------------------------------------------
6) FLUJO OPERATIVO RECOMENDADO
------------------------------------------------------------

1. Abrir repo en VS Code.
2. Ejecutar `Dev Containers: Reopen in Container`.
3. En terminal del container:

   `./scripts/dev-sync-and-run.sh`

Comportamiento del script:

- valida estado git local,
- hace `git pull --ff-only` (si no hay cambios locales),
- levanta Oracle + SonarQube,
- arranca backend con `./mvnw spring-boot:run`.

Para omitir pull:

`SKIP_GIT_PULL=1 ./scripts/dev-sync-and-run.sh`


------------------------------------------------------------
7) AUTO-SYNC GIT EN DEV CONTAINER
------------------------------------------------------------

Variable de control:

- `AUTO_GIT_SYNC_ON_START` (por defecto `1`)

Reglas:

- sin upstream configurado: intenta usar `origin/<branch>`,
- repo limpio y rama atrasada: aplica `pull --ff-only`,
- cambios locales/divergencia/HEAD detached: no hace pull.

Objetivo: evitar sobrescritura de trabajo local y reducir drift de ramas.


------------------------------------------------------------
8) SONARQUBE LOCAL
------------------------------------------------------------

Levantamiento:

`./scripts/sonar-up.sh`

Analisis:

`./scripts/sonar-scan.sh`

Detencion:

`./scripts/sonar-down.sh`

Notas tecnicas:

- Sonar usa PostgreSQL dedicado en compose local.
- `sonar-scan.sh` espera disponibilidad con `wait-sonarqube.sh`.
- Config de proyecto en `sonar-project.properties` y `pom.xml`.
- Maven plugin usado: `org.sonarsource.scanner.maven:sonar-maven-plugin`.

Autenticacion de analisis:

- Recomendado: `SONAR_TOKEN`
- Fallback: `SONAR_USER` + `SONAR_PASSWORD`


------------------------------------------------------------
9) HTTP CLIENT (TIPO POSTMAN) EN VS CODE
------------------------------------------------------------

Extensiones incluidas en Dev Container:

- REST Client (`humao.rest-client`)
- Thunder Client (`rangav.vscode-thunder-client`)

Coleccion tecnica de requests:

- `curl/sb-backend.http`

Uso:

- abrir archivo `.http`,
- ejecutar request por bloque desde VS Code.


------------------------------------------------------------
10) TAREAS DE VS CODE (RUN TASK)
------------------------------------------------------------

Disponibles:

- `Backend: Sync + Run`
- `Backend: Run (skip pull)`
- `Infra: Start (Oracle + SonarQube)`
- `Sonar: Start`
- `Sonar: Analyze`
- `Sonar: Stop`

Ruta:

`Terminal > Run Task`


------------------------------------------------------------
11) COMANDOS DE DIAGNOSTICO
------------------------------------------------------------

Estado Oracle:

`docker compose -f docker/oracle/docker-compose.yml ps`

Estado SonarQube:

`docker compose -f docker/sonarqube/docker-compose.yml ps`

Estado del repo:

`git status`

Validacion Maven basica:

`./mvnw -DskipTests validate`


------------------------------------------------------------
12) FALLAS COMUNES Y RESPUESTA TECNICA
------------------------------------------------------------

1. `git fetch/pull` falla en auto-sync
- Causa probable: credenciales/red/upstream no disponible.
- Accion: validar autenticacion git y ejecutar pull manual.

2. SonarQube no responde en 9000
- Causa probable: proceso aun en bootstrap o conflicto de puertos.
- Accion: revisar logs docker y estado con `docker compose ps`.

3. Backend no arranca
- Causa probable: Oracle no disponible o credenciales datasource invalidas.
- Accion: verificar Oracle arriba y propiedades de datasource.

4. Scripts `.sh` no ejecutan
- Causa probable: permisos en workspace montado.
- Accion: `post-create.sh` corrige permisos; ejecutar con `bash <script>`.


------------------------------------------------------------
13) REFERENCIAS ADICIONALES
------------------------------------------------------------

- `DEVCONTAINER.md`
- `SONARQUBE_LOCAL.md`
- `SWAGGER_SETUP.md`

============================================================
