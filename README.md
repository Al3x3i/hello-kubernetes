# Experiment with Microservices

## Prject

A simplified microservice architecture that can help to understand microservice architecture and extent with new technologies. In this project is applied maximal closeness to a real system.

### Run microservices

#### Run Gateway microservice

`java -jar build/libs/hello-kubernetes-gateway-1.0-SNAPSHOT.jar`

#### Run Backend microservice

`java -jar -Dserver.port=8081 build/libs/hello-kubernetes-backend-1.0-SNAPSHOT.jar `

#### Verify communication between Hello-Kubernetes and Gateway microservices

`curl localhost:8080`

### Run dockerfiles

- First build docker images
- Create docker network
  `$ docker network create hello-kubernetes-network`
- Run backend APP
  `docker run -d -i -t --name hello-kubernetes-backend --network hello-kubernetes-network al3x3i/hello-kubernetes-backend`
- Run gateway APP
  `$ docker run -dit -p 80:8080 --env gateway.secret=hello-kubernetes-secret --env BACKEND_URL=http://hello-kubernetes-backend:8080/ --name hello-kubernetes-gateway --network hello-kubernetes-network al3x3i/hello-kubernetes-gateway`
- Test
  `$ curl localhost`

### Deploy microservices

#### Locally

`cd hello-kubernetes-deploy/locally-deploy`

#### Minikube/Kubernetes

`cd hello-kubernetes-deploy/minikube-deploy`
