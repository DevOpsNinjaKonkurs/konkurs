call mvn clean verify -f ../pom.xml || goto :error

call docker build ../offer-calculator-web --tag offer-calculator-web:latest || goto :error
call docker build ../offer-calculator-view --tag offer-calculator-view:latest || goto :error

goto :EOF

:error
echo Failed with error #%errorlevel%.
exit /b %errorlevel%