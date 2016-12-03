@echo off
echo [INFO] Install jar to local repository.

cd %~dp0
cd ..
call mvn clean package source:jar javadoc:jar deploy:deploy -Dmaven.test.skip=true
cd bin
pause