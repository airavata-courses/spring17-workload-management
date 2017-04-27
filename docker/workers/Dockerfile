FROM goshenoy/workloadbase:1.0
MAINTAINER "Ajinkya Dhamnaskar"

#Args

ARG TASK=$TASK
ENV TASK $TASK
workdir /spring17-workload-management

RUN mkdir logs

ADD workload-task-start.sh ./

CMD sh workload-task-start.sh $TASK



