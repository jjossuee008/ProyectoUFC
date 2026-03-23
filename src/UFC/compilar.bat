@echo off
title Compilador UFC - JDK 25
echo Compilando el proyecto UFC...


set JAVA_HOME=D:\java\jdk25
set JAVAC=%JAVA_HOME%\bin\javac.exe


if not exist "..\bin" mkdir "..\bin"

"%JAVAC%" -d "..\bin" -cp "..\src" "..\src\UFC\funciones\LanzadorUFC.java"

if %errorlevel% equ 0 (
    echo [OK] Compilacion exitosa. Archivos generados en /bin
) else (
    echo [ERROR] Hubo un fallo en la compilacion.
)
pause