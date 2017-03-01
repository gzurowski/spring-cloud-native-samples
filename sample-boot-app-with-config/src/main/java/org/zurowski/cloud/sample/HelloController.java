package org.zurowski.cloud.sample;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${greeting.message:Hello user!}")
    private String greetingMessage;

    @GetMapping(value = "/hello/{name}")
    public Map<String, String> hello(@PathVariable("name") String name) {
        String greeting = String.format(greetingMessage, name);
        return Collections.singletonMap("message", greeting);
    }

}
