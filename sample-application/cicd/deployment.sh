mkdir -p target

kind load docker-image offer-calculator-web:latest
kind load docker-image offer-calculator-view:latest

kubectl delete all,configmap,ingress -l type=application --namespace=offer-calculator
helm template ../offer-calculator-charts/package/application > target/application-final.yaml
kubectl --namespace=offer-calculator apply -f target/application-final.yaml