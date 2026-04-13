# SonarQube local para SB-backend

Esta configuracion deja SonarQube corriendo en Docker y conectado al proyecto Maven.

## Servicios Docker

- `docker/sonarqube/docker-compose.yml`
  - `sonarqube` en `http://localhost:9000`
  - `postgres` para base de datos de SonarQube

## Levantar SonarQube

```bash
./scripts/sonar-up.sh
```

Tambien puedes levantar toda la infraestructura (Oracle + SonarQube):

```bash
./scripts/infra-up.sh
```

Cuando termine de iniciar, entra a:

- URL: `http://localhost:9000`
- Usuario inicial: `admin`
- Password inicial: `admin`

## Ejecutar analisis del proyecto

Opcion 1 (recomendada): token

```bash
export SONAR_TOKEN="TU_TOKEN"
./scripts/sonar-scan.sh
```

`sonar-scan.sh` ya espera automaticamente a que SonarQube este disponible antes de enviar el analisis.

Opcion 2: usuario/password (fallback)

```bash
export SONAR_USER="admin"
export SONAR_PASSWORD="admin"
./scripts/sonar-scan.sh
```

## Apagar SonarQube

```bash
./scripts/sonar-down.sh
```

## Notas

- El proyecto ya incluye:
  - `sonar-project.properties`
  - plugin `sonar-maven-plugin` en `pom.xml`
- Si usas VS Code, tambien tienes tasks:
  - `Sonar: Start`
  - `Sonar: Analyze`
  - `Sonar: Stop`
