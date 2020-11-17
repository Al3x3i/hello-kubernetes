# Run Dockerfile

- Build docker images

- - Backend

```
$ docker build -t al3x3i/hello-kubernetes-backend .
$ docker push al3x3i/hello-kubernetes-backend
```

- - Gateway

```
$ docker build -t al3x3i/hello-kubernetes-gateway .
$ docker push al3x3i/hello-kubernetes-gateway
```

- Push images to Docker Hub
- Create docker network

`$ docker network create hello-kubernetes-network`

- Run backend APP

`$ docker run -d -i -t --name hello-kubernetes-backend --network hello-kubernetes-network al3x3i/hello-kubernetes-backend`

- Run gateway APP

`$ docker run -dit -p 80:8080 --env gateway.secret=hello-kubernetes-secret --env BACKEND_URL=http://hello-kubernetes-backend:8080/ --name hello-kubernetes-gateway --network hello-kubernetes-network al3x3i/hello-kubernetes-gateway`

- Test

`$ curl localhost`
