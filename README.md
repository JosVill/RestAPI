# Spring Boot Rest API

Creación del projecto usando  **Spring Boot**. 
Para mas información visite la web https://spring.io/projects/spring-boot


## Contenido

1. [Dependencias](#dependencias)
2. [Exportar proyecto](#exportar-projecto)
3. [Schema](#schema)


## Dependencias

- Spring Web
- mysql
- lombok
- argon2

```
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.27</version>
	<scope>runtime</scope>
</dependency>
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<version>1.18.20</version>
	<scope>provided</scope>
</dependency>
<dependency>
	<groupId>de.mkammerer</groupId>
	<artifactId>argon2-jvm</artifactId>
	<version>2.11</version>
</dependency>
```

## Exportar proyecto

En intellij Idea boton  **Open**  buscar en la carpeta el archivo descomprimido y esperar a descargar las dependencias

## Schema

**User**
- id: Long
- name: String
- lastname: String
- email: String
- phone: String
- password: String
