FROM goshenoy/workloadbase:1.0
MAINTAINER "Gourav Shenoy"

workdir /spring17-workload-management

RUN mkdir logs

CMD java -jar GraphDatabase/target/Orchestrator-1.0-SNAPSHOT.jar >> logs/orchestrator.log 2>&1 &

