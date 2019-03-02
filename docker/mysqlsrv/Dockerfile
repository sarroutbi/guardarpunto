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
    sudo sed -i 's/^bind-address/#bind-address/' /etc/mysql/my.cnf && \
    sudo service mysql start && \
    mysql -u root -e "CREATE DATABASE guardarpuntodb;\
                      create user 'user1'@'localhost' identified by 'enjutomojamuto';\
                      create user 'user2'@'localhost' identified by 'enjutomojamuto';\
                      grant all on guardarpuntodb.* to 'user1'@'localhost' identified by 'enjutomojamuto';\
                      grant all on guardarpuntodb.* to 'user2'@'localhost' identified by 'enjutomojamuto';\
                      grant all on guardarpuntodb.* to 'user1'@'%' identified by 'enjutomojamuto';\
                      grant all on guardarpuntodb.* to 'user2'@'%' identified by 'enjutomojamuto';\
                      flush privileges;"

# Start with just a shell, mysql will be running appropriately
EXPOSE 3306 33060
CMD ["mysqld"]
