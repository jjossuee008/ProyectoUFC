# UFC Fighter Manager - Java Edition

Sencilla pero potente aplicación de consola desarrollada en **Java 25** para gestionar una base de datos de peleadores de la UFC. Este proyecto permite administrar récords, rankings y automatizar la clasificación por categorías de peso.

## 🚀 Características
* **CRUD Completo:** Alta, baja y listado de peleadores.
* **Lógica de Negocio:** Clasificación automática en categorías de peso (Strawweight hasta Heavyweight).
* **Persistencia:** Exportación e importación de datos mediante archivos `.txt` (formato CSV con `;`).
* **Calidad de Software:** Cobertura de código mediante pruebas unitarias con **JUnit 5**.
* **Documentación:** Generación automática de **Javadoc** y soporte para **Doxygen**.

## Estructura del Proyecto
* `src/`: Código fuente organizado por paquetes.
* `test/`: Pruebas unitarias para validar la lógica de los peleadores.
* `lib/`: Librerías externas (JUnit 5 Standalone).
* `script/`: Automatización mediante archivos `.bat` para compilar, ejecutar y testear.
* `javadoc/`: Documentación técnica del código.

## Instalación y Ejecución

### Requisitos
* Java JDK 21 o superior (Desarrollado en JDK 25).

### Ejecución rápida (Windows)
1. Clona el repositorio o descarga el ZIP.
2. Entra en la carpeta `script/`.
3. Ejecuta `compilar.bat` para generar los binarios.
4. Ejecuta `ejecutar.bat` para iniciar la aplicación.

## Pruebas Unitarias
Para verificar que todo funciona correctamente:
1. Ve a `script/`.
2. Ejecuta `compilar_test.bat`.
3. Ejecuta `ejecutar_tests.bat`.

## Formato de Importación
El sistema acepta archivos `.txt` con el siguiente formato (Punto y coma como separador):
`Nombre;Ranking;Victorias;Derrotas;Nocauts`

Ejemplo:
`Ilia Topuria;C;15;0;8`

---
Desarrollado por **Josué Mateos** - 2026
