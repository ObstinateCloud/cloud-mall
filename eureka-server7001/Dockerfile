FROM openjdk:8
ENV workdir=/root/spring-cloud/eureka-server
RUN mkdir -p /root/spring-cloud/eureka-server
COPY eureka-server-0.0.1.jar ${workdir}
WORKDIR ${workdir}
EXPOSE 8761
CMD ["java","-jar","eureka-server-0.0.1.jar"]
