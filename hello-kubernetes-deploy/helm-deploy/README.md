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

## Helm install

### Validate Helm

`helm install --dry-run --debug <name> <chart-folder>`
`helm install --dry-run --debug --name test-kub-chart kub-chart`

### Install

`helm install --name kub-chart-name kub-chart`

### Check status

```
kubectl get pods
```

### Delete chart

`helm delete kub-chart-name`
OR
`helm del --purge kub-chart-name`

# Create Helm (Can be skipped it is already created)

`helm create kub-chart`
