call mkdir target

call kind create cluster --config kind-config.yaml || goto :error
call kubectl apply -f https://projectcontour.io/quickstart/contour.yaml || goto :error
call kubectl patch daemonsets -n projectcontour envoy -p {"""spec""":{"""template""":{"""spec""":{"""nodeSelector""":{"""ingress-ready""":"""true"""},"""tolerations""":[{"""key""":"""node-role.kubernetes.io/control-plane""","""operator""":"""Equal""","""effect""":"""NoSchedule"""},{"""key""":"""node-role.kubernetes.io/master""","""operator""":"""Equal""","""effect""":"""NoSchedule"""}]}}}} || goto :error
call kubectl create namespace offer-calculator || goto :error
call helm template ../offer-calculator-charts/package/postgresql -n offer-calculator --name-template=offer-calculator > target/postgresql-final.yaml || goto :error
call kubectl --namespace=offer-calculator apply -f target/postgresql-final.yaml || goto :error

goto :EOF

:error
echo Failed with error #%errorlevel%.
exit /b %errorlevel%