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

# Create Helm (Can be skipped it is already created)

`helm create kub-chart`
