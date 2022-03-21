FROM openjdk:11-jdk-slim
VOLUME /tmp
EXPOSE 8761
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]