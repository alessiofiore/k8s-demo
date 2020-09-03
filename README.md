# k8s-demo

## Build
    mvn package
    docker build -t alessiofiore/k8s-demo:1.0.0 .
    docker create -p 9080:8080 --name k8s-demo  alessiofiore/k8s-demo:1.0.0
    docker push alessiofiore/k8s-demo:1.0.0

## K8s
### Enable Ingress
    kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v0.35.0/deploy/static/provider/cloud/deploy.yaml
### Create componentes
    kubectl create secret generic mySecret --from-literal mySecretName=Pippo
    kubectl apply -f k8s/deployment.yml
    kubectl apply -f k8s/service.yml
    kubectl apply -f k8s/ingress.yml
    
### Components management
#### Delete
    kubectl delete -n default secret mySecret
    kubectl delete -n default deployment k8s-demo-deployment
    kubectl delete -n default service k8s-demo-service
    kubectl delete -n default ingress ingress-service
    
## Test
### Container
    GET http://localhost:9080/hello -> Hello
### K8s
    GET http://localhost/hello -> Hello
    

## Utils
    kubectl describe ing ingress-service