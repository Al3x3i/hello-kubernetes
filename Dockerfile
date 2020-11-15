
FROM openjdk:11-jdk

COPY . /app
WORKDIR /app
RUN ./gradlew build

EXPOSE 8080

CMD java -jar build/libs/hello-kubernetes-1.0-SNAPSHOT.jar