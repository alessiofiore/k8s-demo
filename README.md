# k8s-demo

## Build
    mvn clean package
    docker build -t alessiofiore/k8s-demo:1.0.0 .
    docker create -p 9080:8080 --name k8s-demo alessiofiore/k8s-demo:1.0.0
    docker push alessiofiore/k8s-demo:1.0.0

## K8s
### Enable Ingress
    kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v0.35.0/deploy/static/provider/cloud/deploy.yaml
### Components management
#### Create 
    kubectl create secret generic mysecret --from-literal mySecretName=Pippo
    kubectl apply -f k8s/configmap.yaml
    kubectl apply -f k8s/deployment.yaml
    kubectl apply -f k8s/service.yaml
    kubectl apply -f k8s/ingress.yaml
    

#### Delete
    kubectl delete -n default secret mysecret
    kubectl delete -n default configmap k8s-demo-configmap
    kubectl delete -n default deployment k8s-demo-deployment
    kubectl delete -n default service k8s-demo-service
    kubectl delete -n default ingress ingress-service
    
## Test
### Container
    GET http://localhost:9080/hello -> Hi from Spring
### K8s
    GET http://localhost/k8s-demo/hello -> Hello from K8S
    
    # Edit configmap changing "K8S" value
    kubectl edit configmap k8s-demo-custom-configmap
    
    GET http://localhost/k8s-demo/hello -> Hello from {updated value}
    
## Utils
    kubectl describe ing ingress-service