package org.zurowski.cloud.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 
 * @author Gregor Zurowski
 *
 */
@EnableHystrixDashboard
@SpringBootApplication
public class SampleCircuitBreakerDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleCircuitBreakerDashboardApplication.class, args);
    }

}
