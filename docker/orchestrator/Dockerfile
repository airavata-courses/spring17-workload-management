FROM goshenoy/workloadbase:2.0
MAINTAINER "Gourav Shenoy"

workdir /spring17-workload-management

RUN mkdir logs

ADD start-orchestrator.sh /start-orchestrator.sh

RUN chmod +x /start-orchestrator.sh

CMD ["/start-orchestrator.sh"]
