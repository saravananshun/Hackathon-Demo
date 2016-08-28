FROM ubuntu:latest

ARG REPO_NAME
ARG BRANCH

RUN apt-get update && apt-get -y upgrade
# Add oracle java 7 repository
RUN apt-get -y install software-properties-common
RUN add-apt-repository ppa:webupd8team/java
RUN apt-get -y update

# Accept the Oracle Java license
RUN echo "oracle-java7-installer shared/accepted-oracle-license-v1-1 boolean true" | debconf-set-selections
# Install Oracle Java
RUN apt-get -y install oracle-java7-installer git maven curl


RUN mkdir -p /root/.ssh
ADD id_rsa /root/.ssh/id_rsa
RUN chmod 700 /root/.ssh/id_rsa
RUN echo "Host github.com\n\tStrictHostKeyChecking no\n" >> /root/.ssh/config

# Create known_hosts
RUN touch /root/.ssh/known_hosts

RUN mkdir /virtualsource
RUN git clone -b ${BRANCH} https://github.com/saravananshun/${REPO_NAME}.git /virtualsource/${REPO_NAME}
RUN cd /virtualsource/${REPO_NAME} && mvn package


ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH

RUN mkdir -p "$CATALINA_HOME"
WORKDIR $CATALINA_HOME


ENV TOMCAT_MAJOR 8
ENV TOMCAT_VERSION 8.0.32
ENV TOMCAT_TGZ_URL https://www.apache.org/dist/tomcat/tomcat-8/v8.5.4/bin/apache-tomcat-8.5.4.tar.gz

RUN set -x \
    && curl -fSL "$TOMCAT_TGZ_URL" -o tomcat.tar.gz \
    && tar -xvf tomcat.tar.gz --strip-components=1 \
    && rm bin/*.bat \
    && rm tomcat.tar.gz*

RUN cp /virtualsource/spring-mvc-angularjs/target/spring-mvc-angularjs.war $CATALINA_HOME/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]
