# LearningPlatform API

Backend desarrollado con Spring Boot que permite gestionar cursos utilizando almacenamiento temporal en memoria.
El sistema expone endpoints REST para consultar, crear y eliminar cursos.

## Tecnologías utilizadas
- Java 21
- Spring Boot
- Spring Web
- Maven Wrapper
- Arquitectura en capas (Controller, Service, Repository)

## Ejecución del proyecto

Desde la raíz del proyecto ejecutar:
```bash
./mvnw spring-boot:run
```
o en Windows PowerShell:
```bash
./mvnw clean install
./mvnw spring-boot:run
```
La aplicación se iniciará en:
```bash
http://localhost:8080
```
## Arquitectura del proyecto

El proyecto sigue una arquitectura en capas para separar responsabilidades.
```bash
LearningPlatform
│
└── src/main/java/com/duoc/LearningPlatform
    │
    ├── controller
    │   └── CourseController.java
    │
    ├── service
    │   └── CourseService.java
    │
    ├── repository
    │   └── CourseRepository.java
    │
    ├── model
    │   └── Course.java
    │
    ├── config
    │   └── DataLoader.java
    │
    └── LearningPlatformApplication.java
```

## Descripción de capas

#### Controller

Gestiona las solicitudes HTTP y devuelve las respuestas del API.

#### Service

Contiene la lógica de negocio, incluyendo filtrado y ordenamiento de cursos.

#### Repository

Simula una capa de persistencia utilizando estructuras en memoria (ArrayList).

#### Model

Define la estructura de la entidad Course.

#### Config

Contiene DataLoader, encargado de cargar datos iniciales al iniciar la aplicación.

## Modelo de datos

Curso:
```json
{
  "id": 1,
  "name": "Java Básico",
  "description": "Intro a Java",
  "active": true
}
```

|    Campo    |            Descripción             |
|:-----------:|:----------------------------------:|
| id          |      Identificador del curso       |
| name        |          Nombre del curso          |
| description |     Descripción del contenido      |
| active      | Indica si el curso está disponible |

## Lógica de negocio implementada

El servicio aplica las siguientes reglas:

1. Solo se muestran cursos activos.
2. Los cursos se ordenan alfabéticamente por nombre.
3. El ordenamiento ignora mayúsculas y minúsculas.

Esto se implementa utilizando Streams de Java.

## Endpoints disponibles
#### 1. Obtener cursos disponibles

#### Método
```bash
GET
```
#### Ruta
```bash
/api/courses
```
#### Descripción

Devuelve la lista de cursos activos ordenados alfabéticamente.

#### Ejemplo
```bash
http://localhost:8080/api/courses
```
#### Respuesta
```json
[
  {
    "id": 7,
    "name": "algoritmos",
    "description": "Lógica",
    "active": true
  },
  {
    "id": 4,
    "name": "Angular",
    "description": "Frontend",
    "active": true
  },
  {
    "id": 8,
    "name": "Base de Datos",
    "description": "SQL",
    "active": true
  }
]
```
#### 2. Obtener curso por ID

#### Método
```bash
GET
```
#### Ruta
```bash
/api/courses/{id}
```
#### Ejemplo
```bash
http://localhost:8080/api/courses/1
```
#### 3. Crear curso

#### Método
```bash
POST
```
#### Ruta
```bash
/api/courses
```
#### Ejemplo Body
```json
{
  "name": "Docker",
  "description": "Contenedores",
  "active": true
}
```
#### 4. Eliminar curso

#### Método
```bash
DELETE
```
#### Ruta
```bash
/api/courses/{id}
```
## Datos de prueba

Al iniciar la aplicación se cargan automáticamente algunos cursos mediante DataLoader.

Ejemplo:
```bash 
courseRepository.save(new Course(null, "Java Básico", "Intro a Java", true));
courseRepository.save(new Course(null, "Spring Boot", "Microservicios", true));
courseRepository.save(new Course(null, "Python", "Fundamentos", false));
```
Estos datos permiten probar el funcionamiento del servicio sin necesidad de ingresar información manualmente.

## Manejo de errores

El API implementa manejo básico de errores utilizando:

- ResponseEntity
- bloques try-catch
- códigos HTTP apropiados

Ejemplo de error:
```json
{
  "message": "Course not found"
}
```

