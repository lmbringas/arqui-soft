FROM tomcat:8-jdk11

COPY tomcat-users.xml /usr/local/tomcat/conf/
COPY context.xml /usr/local/tomcat/webapps/manager/META-INF/

EXPOSE 8080

CMD ["catalina.sh", "run"]