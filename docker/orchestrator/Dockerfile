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
CMD java -jar GraphDatabase/target/Orchestrator-1.0-SNAPSHOT.jar > logs/orchestrator.log
=======
ADD start-orchestrator.sh /start-orchestrator.sh

RUN chmod +x /start-orchestrator.sh

CMD ["/start-orchestrator.sh"]
>>>>>>> 95d2d6e16e6f817d7b77bacdec5efa91cff34d95
