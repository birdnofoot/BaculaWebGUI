#!/bin/sh
param=$1
for i in $param
do
if [ $i -eq 1 ]
then
  /etc/init.d/bacula-fd restart
fi
if [ $i -eq 2 ]
then
  /etc/init.d/bacula-sd restart
fi
if [ $i -eq 3 ]
then
  /etc/init.d/bacula-director restart
fi
done
