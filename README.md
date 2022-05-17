# Examen 2022-05-17 / Parte práctica

## Pregunta 1. (1 Puntos)

La empresa telecom `icaitelecom.com` está desarrollando un sitio web y 
necesita visualizar en el frontal web, la información relativa a sus productos.

Dado el endpoint `/api/v1/products/` implementa una solución en el frontal web para visualizar 
los datos procedentes de dicho endpoint en la página `/productos.html`.

La visualizacion web mostrara los datos en formato 
de una tabla donde se pueda visualizar los datos de los diferentes productos
que comercializa la compañia.

**Product:**

```json
[
    {
        "id" : 1,
        "name" : "NAME",
        "description" : "DESCRIPTION"
    }
]
```

```
curl 'http://localhost:8080/api/v1/products/'
```

## Pregunta 2. (0,5 Puntos)

Desarrolla un Test E2E sobre el endpoint `/api/v1/products` para verificar su correcto funcionamiento. 
Para la implementación emplea el Objeto `TestRestTemplate`

## Pregunta 3. (6,5 Puntos)

En el proyecto `icaitelecom.com`, se va a desarrollar un area de productos renovada para
la siguiente campaña. 

Desarrolla una feature completa que permita visualizar en `/dispositivos.html` todos los dispositivos y sus tipos 
sobre los datos obtenidos del endpoint: `/api/v1/devices` 
y desarrolla la visualizacion solo de los dispositivos Tablet en el
documento `/dispositivos-tablet.html` sobre los datos obtenidos del endpoint: `/api/v1/devices/tablet`.

```json
[
    {
        "DISPOSITIVO_ID" : 1,
        "DISPOSITIVO" : "DISPOSITIVO",
        "TIPO" : "TIPO"
    }
]
```

Desarrolla la funcionalidad End to End para los endpoints y documentos web: 
`html`, `javascript`, `REST controller`, `service`, `repository`, `entity` & `test`.
En la visualizacion web, los datos se mostraran en formato de una tabla.

Se proporciona un `Schema` y un conjunto de datos sobre datos 
relativos a las tablas `DISPOSITIVO` y `TIPO`.

```sql 
CREATE TABLE  "DISPOSITIVO" (
    "DISPOSITIVO_ID" NUMBER NOT NULL PRIMARY KEY,
    "DISPOSITIVO" VARCHAR2(50) NOT NULL,
    "DESCRIPTION" VARCHAR2(500) NOT NULL,
    "TIPO_ID" NUMBER NOT NULL,
    "SKU" NUMBER NOT NULL
);

CREATE TABLE  "TIPO" (
    "TIPO_ID" NUMBER NOT NULL PRIMARY KEY,
    "TIPO" VARCHAR2(50) NOT NULL,
    "DESCRIPTION" VARCHAR2(500) NOT NULL
);
```

Para la implementación de los tests emplea el Objeto `TestRestTemplate`

## Notas para la implementación de la solución

- Las soluciones entregadas emplearan las dependencias vistas en la asignatura.
- Todas las entregas no tienen que tener problemas de compilacion o errores de Javascript.
- Java 17
