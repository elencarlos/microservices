#FROM maven:3.8.1-jdk-11
#
#ENV TZ=America/Sao_Paulo
#ENV APP_ROOT=/usr/app
#ENV HOME=${APP_ROOT}
#ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS
#ENV UID=1000
#ENV GID=1000
#
#VOLUME ${APP_ROOT}
#WORKDIR ${APP_ROOT}
#
#RUN groupadd ${GID} -g ${GID} \
#    && useradd -m ${UID} -l -u ${UID} -g ${GID} -d /home/user
#RUN chown ${UID}:${GID} -R /root
#
#ENTRYPOINT ["mvn", "spring-boot:run"]

FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]