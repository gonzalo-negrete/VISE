FROM openjdk:slim-buster
COPY "./target/VISE-0.0.1-SNAPSHOT.jar" "VISE.jar"
EXPOSE 8090
ENTRYPOINT ["java","-jar","VISE.jar"]
