FROM dockerfile/java:oracle-java8

VOLUME /tmp
ADD explorer.jar /opt/explorer/
EXPOSE 8080
WORKDIR /opt/explorer/
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms512m", "-Xmx1g", "-jar", "explorer.jar"]
