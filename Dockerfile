FROM java:8-jdk-alpine

COPY ./target/springboot-rest-0.1.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch springboot-rest-0.1.jar'

ENTRYPOINT ["java","-jar","springboot-rest-0.1.jar"]  
