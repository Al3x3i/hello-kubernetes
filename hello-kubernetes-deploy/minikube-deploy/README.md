# Kubernetes/Minikube:

## 1.Start minikube

- minikube https://minikube.sigs.k8s.io/docs/start/

`minikube start`

### 1.1.Open minikube dashboard

`minikube dashboard`

## 2.Create namespace

`kubectl create namespace hello-kubernetes-ns`

## 3.Assign the namespaces as current

`kubectl config set-context --current --namespace=hello-kubernetes-ns`

## 4.Deplay yaml

`kubectl apply -f deploy.yaml`

## 5.Wait Ready status

`kubectl get pods -w `

## 5.1.Check status

`minikube service gateway --url -n hello-kubernetes-ns`

## 6.Open url in browser. Ex: http://192.168.49.2:30500

`firefox $(minikube service gateway --url -n hello-kubernetes-ns)`

## 7.Restart all pods with 2 replicas

```
kubectl get deployments
kubectl scale deployment backend --replicas=0;
kubectl scale deployment backend --replicas=3;

kubectl scale deployment gateway --replicas=0;
kubectl scale deployment gateway --replicas=3;
kubectl get pods -w;

```

## 8.Test kubernetes pod requests

```
for i in`seq 50`; do curl $(minikube service gateway --url -n hello-kubernetes-ns) && echo; done
```

# Kubectl hints/commands

1. List a particular deployment
   `kubectl get deployments`
2. Edit deployoment
   `kubectl edit deployment backend`
