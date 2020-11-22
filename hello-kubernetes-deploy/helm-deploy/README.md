# Start minikube

```
minikube start
minikube dashboard
```

### If `helm init` command fails apply a specific kubernetes version

```
minikube delete
minikube start --kubernetes-version=1.15.4
```

### Create Helm (Can be skipped it is already created)

`helm create kub-chart`

## Helm install

### Validate Helm

`helm install --dry-run --debug <name> <chart-folder>`
`helm install --dry-run --debug --name test-kub-chart kub-chart`

### Install

`helm install --name kub-chart-name kub-chart`

### Check status

```
kubectl get pods -w
helm ls --all

kubectl get service <service_name>  # Like gateway-kub-chart-name
minikube service gateway-kub-chart-name --url
curl $(minikube service gateway-kub-chart-name --url)

```

### Enjoy watching the work of different pods

`for i in `seq 50`; do curl $(minikube service gateway-kub-chart-name --url) && echo; done`

### Delete chart

`helm delete kub-chart-name`
OR
`helm del --purge kub-chart-name`

## Distributing Charts
