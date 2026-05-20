# PROYECTO NTT DATA

Grupo: "AI SpeedRunners"

Este es el proyecto final de las prácticas de NTT DATA


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
cd backend/zoologico-api
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
