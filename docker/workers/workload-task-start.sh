#!/usr/bin/env bash

# parse command arguments
for var in "$@"
do
    case ${var} in
        
	datastaging)
           java -jar workers/DataStaging/target/DataStaging-1.0-SNAPSHOT.jar > logs/datastaging.log 2>&1 &
            shift
        ;;
        jobsubmission)
           java -jar workers/JobSubmissionTask/target/JobSubmissionTask-1.0-SNAPSHOT.jar > logs/jobsubmission.log 2>&1 &
            shift
        ;;
        monitoring)
           java -jar workers/MonitoringTask/target/MonitoringTask-1.0-SNAPSHOT.jar > logs/monitoring.log 2>&1 &
            shift
        ;;
        all)
            java -jar workers/DataStaging/target/DataStaging-1.0-SNAPSHOT.jar > logs/datastaging.log 2>&1 &
            java -jar workers/JobSubmissionTask/target/JobSubmissionTask-1.0-SNAPSHOT.jar > logs/jobsubmission.log 2>&1 &
            java -jar workers/MonitoringTask/target/MonitoringTask-1.0-SNAPSHOT.jar > logs/monitoring.log 2>&1 &
            shift
        ;;    
        -h)
            echo "  datastaging       start datastaging and environmrnt setup task"
            echo "  jobsubmission     start job submission task"
            echo "  monitoring        start monitring task"
            echo "  all               Start all tasks"
            echo "  -h                Display this help and exit"
            shift
            exit 0
        ;;
    esac
done
