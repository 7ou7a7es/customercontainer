FROM tomcat:8-alpine

ADD target/*.war /usr/local/tomcat/webapps/ 
