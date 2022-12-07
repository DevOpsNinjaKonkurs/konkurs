mkdir target

call kind load docker-image offer-calculator-web:latest || goto :error
call kind load docker-image offer-calculator-view:latest || goto :error

call kubectl delete all,configmap,ingress -l type=application --namespace=offer-calculator || goto :error
call helm template ../offer-calculator-charts/package/application > target/application-final.yaml || goto :error
call kubectl --namespace=offer-calculator apply -f target/application-final.yaml || goto :error

goto :EOF

:error
echo Failed with error #%errorlevel%.
exit /b %errorlevel%