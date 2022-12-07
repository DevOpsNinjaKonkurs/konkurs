mvn clean verify -f ../pom.xml

docker build ../offer-calculator-web --tag offer-calculator-web:latest
docker build ../offer-calculator-view --tag offer-calculator-view:latest
