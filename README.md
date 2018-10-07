# Patrones de Diseño
> Este proyecto es la entrega de la práctica ECP2 realizada por Alejandro Puebla Holguin
> ##### [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
> ##### Asignatura: *Arquitectura y Patrones para Aplicaciones Web*

## Diseño de entidades

![Mis entidades](https://github.com/alexph9/APAW.ECP2.Alejandro.Puebla/blob/master/docs/Entities.png)

## Arquitectura
![themes-entities-class-diagram](https://github.com/alexph9/APAW.ECP2.Alejandro.Puebla/blob/master/docs/themes-architecture-diagram.png)

### Responsabilidades
#### Dispatcher
* Centraliza las peticiones y hace de repartidor
* Recupera los datos de la petición y los pasa como parámetros de método
* Captura las excepciones y las convierte en errores Http
#### restControllers
* Define el path del recurso
* Valida la entrada
* Traspasa la petición a los controladores de la capa de negocio
#### businessControllers
* Procesa la petición, apoyándose en los DAO’s
* Crea las entidades a partir de los DTO’s
* Gestiona la respuesta a partir de las entidades. Delega en los DTO’s la creación a partir de la entidad
#### daos
* Gestionan la BD
#### entities
* Son las entidades persistentes en la BD

## API

### POST /artists
#### Parámetros del cuerpo
- `name`: String (**requerido**)
- `isSoloSinger`: Boolean
#### Respuesta
- 200 OK 
  - `id`: String
- 403 BAD_REQUEST
---
### PUT /artists/{id}
#### Parámetros del cuerpo
- `name`: String (**requerido**)
- `isSoloSinger`: Boolean
#### Respuesta
- 200 OK 
- 403 BAD_REQUEST
- 404 NOT_FOUND
--- 
### POST /downloads
#### Parámetros del cuerpo
- `price`: Integer (**requerido**)
#### Respuesta
- 200 OK 
- 403 BAD_REQUEST
---
### POST /songs
#### Parámetros del cuerpo
- `name`: String (**requerido**)
- `genre`: Genre
- `artistId`: String
#### Respuesta
- 200 OK 
  - `id`: String
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### GET /songs
#### Respuesta
- 200 OK 
  - `[ {id:String,name:String} ]`
---
### DELETE /songs/{id}
#### Respuesta
- 200 OK 
---
### PATCH /songs/{id}/genre
#### Parámetros del cuerpo
- `genre`: String (**requerido**)
#### Respuesta
- 200 OK 
- 403 BAD_REQUEST
- 404 NOT_FOUND
---
### GET /songs/search?q=profit:>=10
#### Respuesta
- 200 OK
  - `[ {id:String,name:String} ]`
- 403 BAD_REQUEST
---

## Estado del código

#### Build Status
###### Master
![Build Status](https://travis-ci.org/alexph9/APAW.ECP2.Alejandro.Puebla.svg?branch=master) 
###### Develop
![Build Status](https://travis-ci.org/alexph9/APAW.ECP2.Alejandro.Puebla.svg?branch=develop) 

#### Quality Gate
![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=es.upm.miw%3AAPAW.ECP2.Alejandro.Puebla&metric=alert_status)

### Tecnologías necesarias
* Java
* Maven
* GitHub
* Travis-ci
* Sonarcloud

##### Autor: Alejandro Puebla Holguín
