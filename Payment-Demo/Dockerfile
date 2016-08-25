FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD target/Payment-Demo-0.0.1-SNAPSHOT.jar demo.jar
RUN sh -c 'touch /demo.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo.jar"]
