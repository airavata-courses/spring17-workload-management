<<<<<<< HEAD
FROM workloadbase
MAINTAINER "Ajinkya Dhamnaskar"

#Args
=======
FROM goshenoy/workloadbase:1.0
MAINTAINER "Gourav Shenoy"
>>>>>>> 95d2d6e16e6f817d7b77bacdec5efa91cff34d95

workdir /spring17-workload-management

RUN mkdir logs

<<<<<<< HEAD
CMD java -jar Scheduler/target/Scheduler-1.0-SNAPSHOT.jar > logs/scheduler.log
=======
ADD start-scheduler.sh /start-scheduler.sh

RUN chmod +x /start-scheduler.sh

CMD ["/start-scheduler.sh"]
>>>>>>> 95d2d6e16e6f817d7b77bacdec5efa91cff34d95
