FROM eclipse-temurin:19-jre

WORKDIR ./app

COPY ./build/libs/* ./app.jar

#Already opened port in docker-compose
#EXPOSE 8080
#EXPOSE 8090
#EXPOSE 6001

ENTRYPOINT ["java", "-jar", "app.jar"]

