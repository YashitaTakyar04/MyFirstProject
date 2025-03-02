FROM openjdk:17-jdk-slim

WORKDIR /app

ADD /apiDemo/target/apiDemo-0.0.1-SNAPSHOT.jar /app/apiDemo-docker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "springapi-docker.jar"]
