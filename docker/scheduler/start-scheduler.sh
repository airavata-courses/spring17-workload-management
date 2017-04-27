#!/usr/bin/env bash

# Start Scheduler
java -jar Scheduler/target/Scheduler-1.0-SNAPSHOT.jar > logs/scheduler.log

echo 'Started Scheduler'

exit 0
