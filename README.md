# hello-kubernetes

Experiment with Microservices

## Run Gateway microservice

`java -jar build/libs/gateway-1.0-SNAPSHOT.jar`

## Run Hello-Kubernetes microservice

`java -jar -Dserver.port=8082 build/libs/hello-kubernetes-1.0-SNAPSHOT.jar `

## Verify communication between Hello-Kubernetes and Gateway microservices

`curl localhost:8080`
