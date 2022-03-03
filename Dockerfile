FROM openjdk:8
COPY ./target/booksystem-0.0.1-SNAPSHOT.jar booksystem-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","booksystem-0.0.1-SNAPSHOT.jar"]
