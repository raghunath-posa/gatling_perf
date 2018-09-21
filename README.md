# Gatling performance module

This module is created to check the performance of dogs and cats microservices. There is also a scenario to test the animal mashup sertvice.

# Build and Run Locally using mvn

	mvn clean install

# How to run locally

	mvn gatling:execute -Dgatling.simulationClass=com.test.posa.Dogs

# With Proxy Sample

	mvn gatling:execute -Dgatling.simulationClass=com.test.posa.Dogs -Dhttp.proxyHost=<proxy> -Dhttp.proxyPort=8080 -Dhttps.proxyHost=<proxy> -Dhttps.proxyPort=8080

# With wiremock Recording

    java -jar wiremock-standalone-2.19.0.jar --root-dir="/tmp/wiremock/dogs" --record-mappings --verbose --proxy-all="http://localhost:8090"
    java -jar wiremock-standalone-2.19.0.jar --root-dir="/tmp/wiremock/cats" --record-mappings --verbose --proxy-all="http://localhost:8091"
    java -jar wiremock-standalone-2.19.0.jar

# Local Setup
 

# Todo

- Implement Post Scenario with CSV data.
- Implement Delete Scenario
- Create Complex execution chains to simulate the real load


