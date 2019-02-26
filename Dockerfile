FROM ubuntu:16.04

RUN apt-get update && apt-get install -y software-properties-common
RUN add-apt-repository ppa:openjdk-r/ppa

#RUN apt-get update && apt install -y openjdk-11-jdk && apt -y install openjdk-11-jre

RUN apt-get update && apt -y install openjdk-11-jre

RUN echo "JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64" >> "/etc/environment"

VOLUME /tmp
MAINTAINER Tajul Islam <tajul@linkstaff.co.jp>
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENV SPRING_PROFILES_ACTIVE="cloud"
ENV DB_HOSTNAME="edoc-jobinfo-db"
ENV SPRING_DATASOURCE_USERNAME="edoctor"
ENV SPRING_DATASOURCE_PASSWORD="123456"

ENTRYPOINT ["java","-cp","app:app/lib/*","jp.co.linkstaff.iis.IisEdocJobinfoApiApplication"]

EXPOSE 8080