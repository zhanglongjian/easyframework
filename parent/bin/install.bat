@echo off
echo [INFO] Install jar to local repository.
cd %~dp0
echo %~dp0
cd ..
call mvn clean install -pl . -Dmaven.test.skip=true
cd bin
pause