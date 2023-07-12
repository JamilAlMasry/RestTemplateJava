FROM openjdk:17
ADD target/rest_springboot.jar rest.jar
ENTRYPOINT ["java", "-jar", "rest.jar"]