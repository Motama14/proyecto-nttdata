#!/usr/bin/env bash
cd "$(dirname "$0")"

echo "================================"
echo " Comprobando Java"
echo "================================"
if ! java -version; then
  echo "ERROR: Java no está instalado o no está configurado en el PATH."
  echo "Instala JDK 17 o superior y vuelve a abrir la terminal."
  exit 1
fi

echo
echo "================================"
echo " Comprobando Maven"
echo "================================"
if ! mvn -v; then
  echo "ERROR: Maven no está instalado o no está configurado en el PATH."
  exit 1
fi

echo
echo "================================"
echo " Ejecutando backend Zoologico API"
echo "================================"
mvn spring-boot:run
