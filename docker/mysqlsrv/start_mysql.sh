#!/bin/bash
# 1 - Copy data to pvc disk if it is the first time
test -f /mnt/data/copied
if [ $? -eq 1 ];
then
  cp -arfv /var/lib/mysql/ /mnt/data/
  touch /mnt/data/copied
fi

# 2 - Start database
mysqld --skip-name-resolve --datadir=/mnt/data/mysql/
