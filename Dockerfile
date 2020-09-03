FROM adoptopenjdk/openjdk12:latest
LABEL maintainer="alessiofiore@gmail.com"
COPY target/k8s-demo*.jar k8s-demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/k8s-demo.jar"]