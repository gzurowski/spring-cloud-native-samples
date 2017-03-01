package org.zurowski.cloud.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping(value = "/proxy/hello/{name}")
    public String proxyHello(@PathVariable("name") String name) {
        String url = String.format("//%s/hello/{name}", OTHER_SERVICE);
        return restTemplate.getForObject(url, String.class, name);
    }

}
