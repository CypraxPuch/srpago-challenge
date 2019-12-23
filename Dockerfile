FROM jboss/wildfly
COPY target/srpago-0.0.1-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/srpago-0.0.1-SNAPSHOT.war

