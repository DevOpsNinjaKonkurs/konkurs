mkdir -p target

kubectl apply -f https://projectcontour.io/quickstart/contour.yaml
kubectl patch daemonsets -n projectcontour envoy -p {"""spec""":{"""template""":{"""spec""":{"""nodeSelector""":{"""ingress-ready""":"""true"""},"""tolerations""":[{"""key""":"""node-role.kubernetes.io/control-plane""","""operator""":"""Equal""","""effect""":"""NoSchedule"""},{"""key""":"""node-role.kubernetes.io/master""","""operator""":"""Equal""","""effect""":"""NoSchedule"""}]}}}}
kubectl create namespace offer-calculator
helm install ../offer-calculator-charts/package/postgresql -n offer-calculator --name-template=offer-calculator