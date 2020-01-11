FROM jboss/wildfly
MAINTAINER @ledzedev Gerardo Pucheta
COPY target/srpago-0.0.1-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/srpago-0.0.1-SNAPSHOT.war
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]


# docker build --tag=wildfly-app .
# docker run -it wildfly-app