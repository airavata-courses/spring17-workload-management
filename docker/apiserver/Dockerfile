from goshenoy/workloadbase:1.0
MAINTAINER "Gourav Shenoy"

WORKDIR /spring17-workload-management

ADD start-apiserver.sh /start-apiserver.sh

RUN chmod +x /start-apiserver.sh

WORKDIR /spring17-workload-management/WorkloadAPI

RUN mkdir logs

RUN wget http://central.maven.org/maven2/org/eclipse/jetty/jetty-runner/9.4.4.v20170414/jetty-runner-9.4.4.v20170414.jar

CMD java -jar jetty-runner-9.4.4.v20170414.jar --path /workload --port 8080 --log logs/jetty.log target/WorkloadAPI-1.0-SNAPSHOT.war
