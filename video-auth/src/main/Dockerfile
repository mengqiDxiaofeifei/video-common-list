#FROM java:8
#VOLUME /tmp
#ADD *.jar app.jar
#EXPOSE 8000
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
FROM java:8
MAINTAINER luzc
COPY app.jar /
ENTRYPOINT ["java","-jar","app.jar"]