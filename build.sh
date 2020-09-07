#!/bin/bash

mvn clean package
docker build -t alessiofiore/k8s-demo:1.0.0 .
docker push alessiofiore/k8s-demo:1.0.0