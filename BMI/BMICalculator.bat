@echo off
:run_java
java -jar BMI.jar
echo.
echo Press any key to run again, or Ctrl+C to exit.
pause > nul
goto run_java