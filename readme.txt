============================================================
 DOCUMENTACIÓN TÉCNICA – API
============================================================

Proyecto:
Versión:
Fecha:
Autor:
Repositorio:

------------------------------------------------------------
 DESCRIPCIÓN GENERAL
------------------------------------------------------------



------------------------------------------------------------
 ARQUITECTURA
------------------------------------------------------------



------------------------------------------------------------
 SEGURIDAD
------------------------------------------------------------



------------------------------------------------------------
 MANEJO DE ERRORES
------------------------------------------------------------



------------------------------------------------------------
 ENDPOINTS
------------------------------------------------------------



------------------------------------------------------------
 CURL
------------------------------------------------------------

curl --location 'http://localhost:8080/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
  "username": "",
  "password": ""
}'


curl --location 'http://localhost:8080/v1/users/active-suspended?pageNumber=0&pageSize=10' \
--header 'Authorization: Bearer  <JWT_TOKEN> ' \
--header 'Accept: application/json'


curl --location 'http://localhost:8080/v1/users/extract' \
--header 'Authorization: Bearer <JWT_TOKEN>' \
--header 'Content-Type: application/json' \
--data '{
    "pageNumber": 0,
    "pageSize": 10
  }'


curl --location 'http://localhost:8080/v1/users/search' \
--header 'Authorization: Bearer ' \
--header 'Content-Type: application/json' \
--data '{
  "pageNumber": 0,
  "pageSize": 10
}'


curl --location 'http://localhost:8080/v1/users/deactivate' \
--header 'Authorization: Bearer ' \
--header 'Content-Type: application/json' \
--data '{
  "userId": "aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee"
}'

curl --location 'http://localhost:8080/v1/users/update-without-password' \
--header 'Authorization: Bearer ' \
--header 'Content-Type: application/json' \
--data-raw '{
  "userId": "aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee",
  "userName": "mclaros",
  "firstName": "Miguel",
  "fatherSurname": "Claros",
  "motherSurname": "Quintero",
  "email": "miguel@empresa.com",
  "profileId": "f1e2d3c4-b5a6-7980-9a0b-1c2d3e4f5a6b",
  "userStatusId": 1,
  "authenticationTypeId": 1
}'



------------------------------------------------------------
 NOTAS TÉCNICAS
------------------------------------------------------------



============================================================
 FIN DOCUMENTO
============================================================





