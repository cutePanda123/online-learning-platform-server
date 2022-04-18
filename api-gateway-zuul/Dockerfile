FROM adoptopenjdk/openjdk8
MAINTAINER cutepanda123 panda@panda.com

COPY target/api-gateway-zuul-1.0-SNAPSHOT.jar /api-gateway-zuul.jar

ENTRYPOINT ["java", "-jar", "/api-gateway-zuul.jar"]