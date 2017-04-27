FROM goshenoy/workloadbase:1.0
MAINTAINER "Gourav Shenoy"

workdir /spring17-workload-management

RUN mkdir logs

ADD start-scheduler.sh /start-scheduler.sh

RUN chmod +x /start-scheduler.sh

CMD ["/start-scheduler.sh"]
