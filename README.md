# Spring Cloud Native Samples

Demonstrates the use of the following Spring Cloud components:

- Circuit Breaker / Hystrix
- Config Server
- Service Registry / Eureka

## How to build

Clone this repository and build all samples from the project's root directory using Maven:

```
$ mvn clean package
```

## Running the samples

Change into a specific sample module and use the [Spring Boot Maven Plugin](http://docs.spring.io/spring-boot/docs/current/maven-plugin/usage.html) for running it, for example:

```
$ cd sample-boot-app
$ mvn spring-boot:run
```
