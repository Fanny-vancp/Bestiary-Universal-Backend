FROM openjdk:17

COPY build/libs/Bestiary-Universal-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java","-jar","Bestiary-Universal-0.0.1-SNAPSHOT.jar"]