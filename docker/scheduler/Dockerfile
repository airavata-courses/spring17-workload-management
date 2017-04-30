FROM goshenoy/workloadbase:2.0
MAINTAINER "Gourav Shenoy"

workdir /spring17-workload-management

RUN mkdir logs

ADD start-scheduler.sh /
RUN chmod +x /start-scheduler.sh

CMD ["/start-scheduler.sh"]
