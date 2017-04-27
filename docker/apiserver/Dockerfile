from goshenoy/workloadbase:1.0
MAINTAINER "Gourav Shenoy"

WORKDIR /spring17-workload-management

ADD start-apiserver.sh /start-apiserver.sh

RUN chmod +x /start-apiserver.sh

WORKDIR /spring17-workload-management/WorkloadAPI

RUN mkdir logs

CMD ["/start-apiserver.sh"]

