# Spring Boot APP with Kubernetes

## Stack
- 'dive' Analyze Docker image https://github.com/wagoodman/dive

## Run Backend service
`
$ ./gradlew build
$ java -Dserver.port=8081 -jar build/libs/hello-kubernetes-backend-1.0-SNAPSHOT.jar
`

## Build and run the project
`
$ ./gradlew build && java -jar build/libs/hello-kubernetes-backend-1.0-SNAPSHOT.jar
`
## List commands to work with Dockerfile
### It is one of options of Dockerfile and how to build it. Ex: https://spring.io/blog/2018/11/08/spring-boot-in-a-container
`
$ docker build -t al3x3i/hello-kubernetes-backend .
`
### After Dockerfile build, it can be launched by
`
$ docker run -p 8081:8081 al3x3i/hello-kubernetes-backend
`
### Check docker image in shell
`
$ ddocker run -p 8081:8081 -it al3x3i/hello-kubernetes-backend sh
`
### Stop all docker containers
`
$ docker stop $(docker ps -q)
`
### Check App index endpoint
`
$ curl localhost:8081
`
### Upload Docker image to Docker Hub
```
$ docker login -u {LOGIN} -p {PASSWORD}
$ docker push al3x3i/hello-kubernetes-backend
```
### Kubernetes TODO

