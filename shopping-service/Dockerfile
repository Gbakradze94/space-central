FROM eclipse-temurin:17
WORKDIR workspace
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} shopping-service.jar
ENTRYPOINT ["java", "-jar", "shopping-service.jar"]