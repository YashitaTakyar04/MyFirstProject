FROM openjdk:17-jdk-alpine

WORKDIR /app

ADD target/apiDemo-0.0.1-SNAPSHOT.jar /app/apiDemo-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "apiDemo-0.0.1-SNAPSHOT.jar"]
