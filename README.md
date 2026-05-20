# PROYECTO NTT DATA

Grupo: "AI SpeedRunners"

Este es el proyecto final de las prácticas de NTT DATA


# Memoria del proyecto: Gestión de zoológico

## 1. Descripción general

El proyecto consiste en una aplicación web para gestionar los cuidadores y animales de un zoológico. La idea principal es representar una relación 1:M, donde un cuidador puede tener muchos animales asignados, pero cada animal tiene un único cuidador responsable.

Con esta estructura podemos consultar los datos de los cuidadores, ver el detalle de uno concreto, crear nuevos cuidadores, crear animales y comprobar qué animales tiene asignados cada cuidador.

## 2. Modelo de datos

El modelo de datos está formado por dos entidades principales:

### Cuidador

Representa a los trabajadores responsables del cuidado de los animales del zoológico.

Campos principales:

- id
- nombre
- apellidos
- email
- teléfono
- especialidad
- turno
- fecha de alta

### Animal

Representa a los animales que viven en el zoológico.

Campos principales:

- id
- nombre
- especie
- hábitat
- edad
- estado de salud
- fecha de ingreso
- cuidador responsable

## 3. Relación entre entidades

La relación elegida es 1:M:

```text
Cuidador 1 -------- M Animal
```

Esto significa que un cuidador puede tener varios animales asignados. En la base de datos, esta relación se guarda mediante la clave foránea `cuidador_id` dentro de la tabla `animales`.

## 4. Backend

El backend está desarrollado con Java y Spring Boot. Se ha creado una API REST para comunicar el frontend con la base de datos.

La aplicación usa una base de datos H2 en memoria, por lo que no hace falta instalar una base de datos externa. Cada vez que arrancamos el proyecto, se crean las tablas y se cargan algunos datos iniciales para poder probar la aplicación.

La estructura del backend se divide en varias capas:

- `model`: contiene las entidades JPA.
- `repository`: contiene los repositorios que acceden a la base de datos.
- `service`: contiene la lógica de negocio.
- `controller`: expone los endpoints REST.
- `dto`: contiene los objetos que se envían y reciben en la API.
- `exception`: gestiona errores de forma más clara.

## 5. Frontend

El frontend está desarrollado con Angular 21. La aplicación utiliza componentes standalone, rutas básicas, formularios reactivos, servicios para llamar a la API REST y signals para manejar parte del estado.

Las vistas principales son:

- Inicio.
- Listado de cuidadores.
- Detalle de cuidador y animales asignados.
- Formulario para crear cuidadores.
- Formulario para crear animales.

## 6. Operaciones implementadas

La aplicación permite realizar las siguientes operaciones:

- Listar cuidadores.
- Ver el detalle de un cuidador.
- Crear cuidadores.
- Crear animales.
- Consultar los animales asignados a un cuidador.
- Listar animales.
- Actualizar y eliminar registros desde la API.

## 7. Conclusión

Este proyecto cumple los requisitos mínimos pedidos porque incluye dos entidades relacionadas con una relación 1:M, una API REST funcional con Spring Boot, persistencia con una base de datos relacional H2 y un frontend en Angular que consume los datos mediante servicios. Además, se han añadido operaciones de edición y borrado en el backend para dejar el proyecto más completo.


# Checklist de requisitos del proyecto

## Modelo de datos mínimo

| Requisito | Cómo se cumple |
|---|---|
| Al menos dos entidades | `Cuidador` y `Animal` |
| Relación 1:M | Un `Cuidador` tiene muchos `Animal` |
| Entidad principal | `Cuidador` |
| Entidad hija | `Animal` |

## Operaciones mínimas de la API

| Requisito | Endpoint usado |
|---|---|
| Listar datos | `GET /api/cuidadores` y `GET /api/animales` |
| Ver detalle de un elemento | `GET /api/cuidadores/{id}` y `GET /api/animales/{id}` |
| Crear nuevos registros | `POST /api/cuidadores` y `POST /api/animales` |
| Consultar relación entre principal e hija | `GET /api/cuidadores/{id}/animales` |
| Edición y borrado opcional | `PUT` y `DELETE` en cuidadores y animales |

## Requisitos obligatorios del backend

| Requisito | Cómo se cumple |
|---|---|
| Java con Spring Boot | Proyecto Maven con Spring Boot |
| API REST expuesta y funcional | Controladores `CuidadorController` y `AnimalController` |
| Operaciones básicas sobre datos | Servicios, repositorios y endpoints CRUD |
| Base de datos H2 en memoria | Configuración en `application.properties` |
| Relación 1:M entre dos tablas | `@OneToMany` en `Cuidador` y `@ManyToOne` en `Animal` |
| Persistencia relacional | Spring Data JPA + H2 |

## Requisitos obligatorios del frontend

| Requisito | Cómo se cumple |
|---|---|
| Angular 21 | Proyecto configurado en `package.json` |
| Componentes standalone | Todos los componentes tienen `standalone: true` |
| Signals | Servicio `ZooStoreService` usa `signal` y `computed` |
| Formularios reactivos | Componentes `CuidadorFormComponent` y `AnimalFormComponent` |
| Llamadas API REST desde servicios | `CuidadorApiService` y `AnimalApiService` |
| Observables en servicios | Métodos HTTP devuelven `Observable<T>` |
| Navegación con rutas | Archivo `app.routes.ts` |





# BACKEND

## Ejecución del backend

Este backend no necesita crear ninguna variable de entorno propia del proyecto.

La base de datos H2 está configurada directamente en:

```text
src/main/resources/application.properties
```

La configuración usada es:

```properties
spring.datasource.url=jdbc:h2:mem:zoodb
spring.datasource.username=sa
spring.datasource.password=
```

Por tanto, para la práctica no hace falta crear `.env`, `DATABASE_URL`, usuario de base de datos ni contraseña.

### Requisitos del ordenador

Para abrir y ejecutar el backend sí hace falta tener instalado:

- JDK 17 o superior.
- Maven.

Comprobación en terminal:

```bash
java -version
mvn -v
```

### Ejecutar el backend

Desde la carpeta del backend:

```bash
cd backend/
mvn spring-boot:run
```

La API queda disponible en:

```text
http://localhost:8080/api
```

La consola de H2 queda disponible en:

```text
http://localhost:8080/h2-console
```

Datos para entrar en H2:

```text
JDBC URL: jdbc:h2:mem:zoodb
User Name: sa
Password: dejar vacío
```

### Error típico con JAVA_HOME

Si aparece un error parecido a:

```text
JAVA_HOME is not defined correctly
```

no es un error del código del proyecto. Significa que el ordenador no tiene configurado correctamente Java para ejecutar Maven.

Solución rápida:

1. Instalar JDK 17 o JDK 21.
2. Reiniciar VS Code o IntelliJ.
3. Comprobar otra vez:

```bash
java -version
mvn -v
```

En IntelliJ también se puede corregir desde:

```text
File > Project Structure > Project SDK
```

Seleccionando un JDK 17 o superior.

### Error típico con Maven

Si aparece:

```text
mvn no se reconoce como un comando interno o externo
```

significa que Maven no está instalado o no está añadido al PATH del sistema. En ese caso hay que instalar Maven o ejecutar el proyecto desde IntelliJ usando la pestaña Maven.


# FRONTEND
Aqui va todo lo relacionado con el FrontEnd

## Comandos del frontend

cd frontend/
npm install
npm start
Abrir en el navegador: http://localhost:4200

# INTEGRANTES DEL GRUPO
--Juan Gómez Ruiz
--Ian Castellano Martínez
--Juan Carlos Del Pozo Pineda
--Sergio Alcaide Ortiz
--Moatamed Pérez Haggoud