@echo off
title Ejecutar UFC - JDK 25
echo Iniciando programa UFC...

set JAVA_HOME=D:\java\jdk25
set JAVA=%JAVA_HOME%\bin\java.exe

"%JAVA%" -cp "..\bin" UFC.funciones.LanzadorUFC

pause