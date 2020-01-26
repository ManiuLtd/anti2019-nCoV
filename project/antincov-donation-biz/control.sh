#!/usr/bin/env bash
pid=0
JVM_ARGS=" -Xms3g -Xmx3g -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:+UseCMSInitiatingOccupancyOnly -Xloggc:log/gc.log -XX:+PrintGCDetails"
PACKAGE_NAME="antincov-donation-biz.jar"
DEPLOY_DIR=`pwd`
STDOUT_FILE=$DEPLOY_DIR/../stdout.log

nohup java -jar ${JVM_ARGS} -Dspring.profiles.active=${PROFILE} ${PACKAGE_NAME}  > $STDOUT_FILE 2>&1 &


