# Experiment with Microservices

## Prject

A simplified microservice architecture that can help to understand microservice architecture and extent with new technologies. In this project is applied maximal closeness to a real system.

### Run Gateway microservice

`java -jar build/libs/gateway-1.0-SNAPSHOT.jar`

### Run Hello-Kubernetes microservice

`java -jar -Dserver.port=8082 build/libs/hello-kubernetes-1.0-SNAPSHOT.jar `

### Verify communication between Hello-Kubernetes and Gateway microservices

`curl localhost:8080`
