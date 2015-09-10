#!/bin/sh

/usr/bin/bconsole -c /etc/bacula/bconsole.conf << END_OF_DATA
run job=$1
yes
messages
END_OF_DATA
