FROM openjdk:8-jdk-alpine

COPY target/*.jar ./

EXPOSE 8080

ENTRYPOINT java -Xmx600m -XX:MaxMetaspaceSize=100m -jar $(find / -maxdepth 1 -name '*.jar')
