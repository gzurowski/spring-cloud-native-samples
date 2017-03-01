package org.zurowski.cloud.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Gregor Zurowski
 *
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return String.format("Hello %s", name);
    }

}
