# Pull base image
FROM ubuntu:14.04

# Update latest software and install java modules
# software-properties-common needed for add-apt-repository command
RUN sudo apt-get update && \
    sudo apt-get -q -y install mysql-server && \
    sudo apt-get install -y software-properties-common && \
    sudo apt-add-repository ppa:openjdk-r/ppa && \
    sudo apt-get update && \
    sudo apt-get install -y openjdk-8-jre && \
    sudo service mysql start && \
    mysql -u root -e "CREATE DATABASE guardarpuntodb;\
                      create user root@192.168.33.11 identified by 'enjutomojamuto';\
                      grant all privileges on guardarpuntodb.* to user1@192.168.33.11;\
                      grant all privileges on guardarpuntodb.* to user2@192.168.33.12;\
                      flush privileges;"

# Start with just a shell, mysql will be running appropriately
EXPOSE 3306 33060
CMD ["mysqld"]
