@echo off
cd /d %~dp0

echo ================================
echo  Comprobando Java
echo ================================
java -version
if errorlevel 1 (
    echo.
    echo ERROR: Java no esta instalado o no esta configurado en el PATH.
    echo Instala JDK 17 o superior y vuelve a abrir la terminal.
    pause
    exit /b 1
)

echo.
echo ================================
echo  Comprobando Maven
echo ================================
mvn -v
if errorlevel 1 (
    echo.
    echo ERROR: Maven no esta instalado o no esta configurado en el PATH.
    echo Puedes instalar Maven o abrir el proyecto en IntelliJ y ejecutarlo desde la pestaña Maven.
    pause
    exit /b 1
)

echo.
echo ================================
echo  Ejecutando backend Zoologico API
echo ================================
mvn spring-boot:run
pause
