FROM openjdk:8-jdk-alpine
WORKDIR "/home"
COPY . .
RUN apk add maven
WORKDIR "/home/demo"
EXPOSE 8080
COPY pom.xml /booksystem/pom.xml
CMD [ "java", "-jar",  "/home/demo/target/booksystem-0.0.1-SNAPSHOT.jar"]
