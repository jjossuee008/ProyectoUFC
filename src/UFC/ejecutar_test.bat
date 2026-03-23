@echo off
title Ejecutor de Tests UFC - Josue Mateos
cd /d "%~dp0"
cd ..


set JAVA_HOME=D:\java\jdk25
set JAVA_EXE="%JAVA_HOME%\bin\java.exe"

set LIB_JUNIT=lib\junit-platform-console-standalone-1.10.0.jar

echo ===========================================
echo   EJECUTANDO PRUEBAS UNITARIAS (JUNIT 5)
echo ===========================================


%JAVA_EXE% -jar %LIB_JUNIT% -cp bin --scan-classpath

echo ===========================================
pause