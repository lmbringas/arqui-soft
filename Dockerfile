FROM tomcat:8-jdk11

COPY ./target/*.war /usr/local/tomcat/webapps/
COPY tomcat-users.xml /usr/local/tomcat/conf/

EXPOSE 8080


CMD ["catalina.sh", "run"]