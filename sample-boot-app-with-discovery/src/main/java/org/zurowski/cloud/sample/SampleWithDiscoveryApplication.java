package org.zurowski.cloud.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 
 * @author Gregor Zurowski
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SampleWithDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleWithDiscoveryApplication.class, args);
    }

}