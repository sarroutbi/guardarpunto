# Pull base image
FROM ubuntu:14.04

# Variables
ENV REPOSITORY https://github.com/sarroutbi/guardarpunto.git
ENV INTERNAL_SRVC_PATH ./guardarpunto/MailRestPost/target/MailRestPost-0.0.1-SNAPSHOT.jar
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
ENV PATH $PATH:$JAVA_HOME/bin

# Update latest software and install java modules
# software-properties-common needed for add-apt-repository command
RUN sudo apt-get update && \
    sudo apt-get install -y git && \
    sudo apt-get install -y software-properties-common && \
    sudo apt-add-repository ppa:webupd8team/java && \
    sudo add-apt-repository ppa:openjdk-r/ppa && \
    sudo apt-get update && \
    echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | sudo debconf-set-selections && \
    sudo apt-get install -y oracle-java8-installer && \
    sudo apt-get install -y openjdk-8-jre

# Clone software source
RUN git clone -v ${REPOSITORY} && pwd && \
    cp -v ${INTERNAL_SRVC_PATH} .

# Run web application
# TODO: Substitue ile with INTERNAL_SRVC_PATH env variable
CMD ["java", "-jar", "./guardarpunto/MailRestPost/target/MailRestPost-0.0.1-SNAPSHOT.jar"]
