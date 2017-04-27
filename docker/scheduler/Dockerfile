FROM workloadbase
MAINTAINER "Ajinkya Dhamnaskar"

#Args

workdir /spring17-workload-management

RUN mkdir logs

CMD java -jar Scheduler/target/Scheduler-1.0-SNAPSHOT.jar > logs/scheduler.log
