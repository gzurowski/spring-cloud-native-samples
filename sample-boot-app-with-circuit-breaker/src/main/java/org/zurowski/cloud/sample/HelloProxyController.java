package org.zurowski.cloud.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 * @author Gregor Zurowski
 *
 */
@RestController
public class HelloProxyController {

    private static final String OTHER_SERVICE = "SAMPLE-BOOT-APP-WITH-DISCOVERY";

    private RestTemplate restTemplate;

    @Autowired
    public HelloProxyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "proxyHelloFallback")
    @GetMapping(value = "/proxy/hello/{name}")
    public String proxyHello(@PathVariable("name") String name) {
        String url = String.format("//%s/hello/{name}", OTHER_SERVICE);
        return restTemplate.getForObject(url, String.class, name);
    }

    @SuppressWarnings("unused")
    private String proxyHelloFallback(String name) {
        return String.format("Hi %s from fallback!", name);
    }

}
