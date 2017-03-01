package org.zurowski.cloud.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Gregor Zurowski
 *
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class SampleWithCircuitBreakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleWithCircuitBreakerApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
