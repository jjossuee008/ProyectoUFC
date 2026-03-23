@echo off
title Compilador Definitivo UFC - Josue Mateos
cd /d "%~dp0"
cd ..


set JAVA_HOME=D:\java\jdk25
set JAVAC_EXE="%JAVA_HOME%\bin\javac.exe"


set JAR_JUNIT="D:\UFC_JosueMateos\lib\junit-platform-console-standalone-1.10.0.jar"
set CARPETA_BIN="D:\UFC_JosueMateos\bin"

echo ===========================================
echo              COMPILANDO TESTS 
echo ===========================================

:: 4. Compilamos usando las rutas completas
%JAVAC_EXE% -d %CARPETA_BIN% -cp "%JAR_JUNIT%;%CARPETA_BIN%" src\UFC\test\*.java

if %errorlevel% equ 0 (
    echo.
    echo [OK] Compilacion exitosa. Los .class estan en bin.
) else (
    echo.
    echo [ERROR] Sigue sin encontrarlo. 
    echo Revisa que no haya espacios raros en el nombre del archivo en /lib.
)
pause