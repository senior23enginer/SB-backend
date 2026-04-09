# 🚀 Guía para Levantar el Proyecto con OpenAPI Swagger

## ✅ Cambios Realizados

Se ha configurado exitosamente OpenAPI Swagger en el proyecto. Los cambios realizados incluyen:

### 1. **Dependencias Agregadas (pom.xml)**
   - `springdoc-openapi-starter-webmvc-ui` v2.0.2 - Proporciona Swagger UI e integración con OpenAPI 3.0

### 2. **Configuración de Propiedades (application.properties)**
   - Rutas de API Docs configuradas
   - Swagger UI habilitado y personalizado
   - Ordenamiento de tags y operaciones

### 3. **Clases de Configuración Creadas**
   - `OpenApiConfig.java` - Configuración de metadatos de OpenAPI
   - `SecurityConfig.java` - Configuración de seguridad para permitir acceso a Swagger

---

## 🏃 Pasos para Ejecutar el Proyecto

### Opción 1: Ejecutar con Maven (Recomendado para desarrollo)

```bash
cd /Users/faustoospina/Documents/GitHub/SB-backend

# Compilar el proyecto
./mvnw clean compile

# Ejecutar la aplicación
./mvnw spring-boot:run
```

### Opción 2: Compilar y ejecutar el JAR

```bash
cd /Users/faustoospina/Documents/GitHub/SB-backend

# Compilar y empaquetar
./mvnw clean package -DskipTests

# Ejecutar
java -jar target/interfaz-contable-0.0.1-SNAPSHOT.jar
```

---

## 📍 Acceder a Swagger UI

Una vez que la aplicación esté ejecutándose, accede a:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **API Docs (JSON)**: http://localhost:8080/v3/api-docs
- **API Docs YAML**: http://localhost:8080/v3/api-docs.yaml

---

## 🔧 Requisitos Previos

### Configuración de Base de Datos Oracle
La aplicación requiere una conexión a Oracle. Asegúrate de que:

1. **Oracle Database está ejecutándose** en:
   - Host: `localhost`
   - Port: `1521`
   - SID: `FREEPDB1`

2. **Las credenciales son correctas** (configuradas en application.properties):
   ```properties
   spring.datasource.username=system
   spring.datasource.password=Oracle123
   ```

3. **Si necesitas cambiar la conexión**, edita:
   ```
   src/main/resources/application.properties
   ```

---

## 📊 Estructura de Endpoints Disponibles

El proyecto cuenta con controladores REST para gestionar:
- **DdBultos** (Bultos de despacho)
- Y otros módulos de picking

Todos los endpoints están documentados automáticamente en Swagger UI.

---

## 🛡️ Seguridad

- Las rutas de Swagger están permitidas **sin autenticación**
- Los endpoints del API requieren autenticación JWT
- La configuración está en `SecurityConfig.java`

---

## 📝 Notas Importantes

- La versión de Java requerida es **Java 21**
- Spring Boot version: **3.5.7**
- La compilación fue **exitosa** sin errores

---

## 🐛 Solución de Problemas

### Error: "Permission denied: ./mvnw"
```bash
chmod +x ./mvnw
```

### Error de conexión a Oracle
```bash
# Verifica que Oracle esté ejecutándose en docker (si tienes configurado)
docker ps
docker-compose -f oracle/docker-compose.yml up -d
```

### Puerto 8080 ya en uso
```bash
# Ejecutar en un puerto diferente
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

---

## 📚 Referencias

- [SpringDoc OpenAPI](https://springdoc.org/)
- [Swagger UI Documentation](https://swagger.io/tools/swagger-ui/)
- [OpenAPI 3.0 Specification](https://spec.openapis.org/oas/v3.0.3)
- [Spring Security Documentation](https://spring.io/projects/spring-security)


