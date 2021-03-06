DROP TABLE IF EXISTS DISPOSITIVO;

CREATE TABLE  "DISPOSITIVO" (
    "DISPOSITIVO_ID" NUMBER NOT NULL PRIMARY KEY,
	"DISPOSITIVO" VARCHAR2(50) NOT NULL,
	"DESCRIPTION" VARCHAR2(500) NOT NULL,
	"TIPO_ID" NUMBER NOT NULL,
	"SKU" NUMBER NOT NULL
);

DROP TABLE IF EXISTS TIPO;

CREATE TABLE  "TIPO" (
    "TIPO_ID" NUMBER NOT NULL PRIMARY KEY,
	"TIPO" VARCHAR2(50) NOT NULL,
	"DESCRIPTION" VARCHAR2(500) NOT NULL
);