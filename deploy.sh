#!/bin/bash

kubectl delete -n default configmap k8s-demo-configmap
kubectl delete -n default configmap k8s-demo-custom-configmap
kubectl delete -n default deployment k8s-demo-deployment
kubectl apply -f k8s/configmap.yaml
kubectl apply -f k8s/configmap2.yaml
kubectl apply -f k8s/deployment.yaml