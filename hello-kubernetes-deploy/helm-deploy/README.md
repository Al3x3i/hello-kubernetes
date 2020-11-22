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

`helm install --name kub-chart-name ./kub-chart`

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

1. Create repository al3x3i.github.io.git

2. Create `doc` folder and copy `kub-chart` folder to the `al3x3i.github.io.git` repository

3. Create Helm Package

`helm package kub-chart/ -d docs/`

3.1. Create index.yaml for our chart repo:

`helm repo index docs/ --url https://al3x3i.github.io/docs`

4. Push this to repo: al3x3i.github.io ("Your GitHub Pages" is `\`, this is why is required to provide `docs` in URL path)

5. Add helm repo to your repositories

`helm repo add kub-chart-repo https://al3x3i.github.io/docs`

6. Update helm repos

`helm repo update`

6.1. Optional, use only for testing purposes

```
kubectl create clusterrolebinding serviceaccounts-cluster-admin \
 --clusterrole=cluster-admin \
 --group=system:serviceaccounts
```

7. Install helm repo by passing custom settings

helm install --name hello-kubernetes-project kub-chart-repo/kub-chart \
--set backend.container.resources.requests.cpu=50m \
--set backend.hpa.enabled=true \
--set gateway.container.resources.requests.cpu=50m \
--set gateway.hpa.enabled=true \
--set secrets.secret=secret

8. Test installation

`minikube serive gateway-hello-kubernetes-project`

9. Clean install

```
helm repo remove kub-chart-repo
helm del --purge hello-kubernetes-project

```
