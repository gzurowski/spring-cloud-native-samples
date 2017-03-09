FROM openjdk:8-jre-alpine
ADD target/sample-boot-app-*.jar app.jar
EXPOSE 8080
ENV PORT=8080
ENV JAVA_OPTS="-Dspring.profiles.active=cloud"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
