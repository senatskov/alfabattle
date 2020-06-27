FROM openjdk:11-jre-slim
VOLUME /tmp
EXPOSE 8080
ADD target/task1-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]