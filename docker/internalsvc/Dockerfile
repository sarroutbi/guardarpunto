# Pull base image
FROM ubuntu:14.04

# Update latest software and install java modules
# software-properties-common needed for add-apt-repository command
RUN sudo apt-get update && \
    sudo apt-get install -y software-properties-common && \
    sudo apt-add-repository ppa:webupd8team/java && \
    sudo add-apt-repository ppa:openjdk-r/ppa && \
    sudo apt-get update && \
    echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | sudo debconf-set-selections && \
    sudo apt-get install -y oracle-java8-installer && \
    sudo apt-get install -y openjdk-8-jre
