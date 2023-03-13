FROM adoptopenjdk/openjdk11

COPY ./build/libs/movie-0.0.1-SNAPSHOT.jar /build/libs/movie-0.0.1-SNAPSHOT.jar

CMD ["java","-jar","/build/libs/movie-0.0.1-SNAPSHOT.jar"]