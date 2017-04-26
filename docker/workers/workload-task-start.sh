#!/usr/bin/env bash

# parse command arguments
for var in "$@"
do
    case ${var} in
        
	datastaging)
           java -jar workers/DataStaging/target/DataStaging-1.0-SNAPSHOT.jar > logs/datastaging.log
            shift
        ;;
        jobsubmission)
           java -jar workers/JobSubmissionTask/target/JobSubmissionTask-1.0-SNAPSHOT.jar > logs/jobsubmission.log
            shift
        ;;
        monitoring)
           java -jar workers/MonitoringTask/target/MonitoringTask-1.0-SNAPSHOT.jar > logs/monitoring.log
            shift
        ;;
        all)
            java -jar workers/DataStaging/target/DataStaging-1.0-SNAPSHOT.jar > logs/datastaging.log &
            java -jar workers/JobSubmissionTask/target/JobSubmissionTask-1.0-SNAPSHOT.jar > logs/jobsubmission.log &
            java -jar workers/MonitoringTask/target/MonitoringTask-1.0-SNAPSHOT.jar > logs/monitoring.log
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
