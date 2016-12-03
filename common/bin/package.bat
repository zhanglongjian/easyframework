@echo off
echo [INFO] Runing...
cd %~dp0
cd ..
call mvn clean package -Dmaven.test.skip=true -Dpackage.bin=true
pause