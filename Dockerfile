FROM openjdk

VOLUME /tmp

EXPOSE 9898

ADD target/NgSbIntegrationAppPostMethod-0.0.1-SNAPSHOT.jar NgSbIntegrationAppPostMethod-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java","-jar","/NgSbIntegrationAppPostMethod-0.0.1-SNAPSHOT.jar" ]