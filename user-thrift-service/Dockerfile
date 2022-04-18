FROM adoptopenjdk/openjdk8
MAINTAINER cutepanda123 panda@panda.com

COPY target/user-thrift-service-1.0-SNAPSHOT.jar /user-service.jar

ENTRYPOINT ["java", "-jar", "/user-service.jar"]