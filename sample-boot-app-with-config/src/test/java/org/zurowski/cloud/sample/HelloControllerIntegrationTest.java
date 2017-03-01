package org.zurowski.cloud.sample;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.config.server.ConfigServerApplication;
import org.springframework.cloud.config.server.test.ConfigServerTestUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.jsonpath.JsonPath;

/**
 * see
 * https://github.com/spring-cloud/spring-cloud-config/blob/master/spring-cloud-config-sample/src/test/java/sample/ApplicationTests.java
 * 
 * @author Gregor Zurowski
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleWithConfigApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT, properties = {
        "spring.cloud.config.enabled:true", "management.security.enabled=false" })
public class HelloControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private static ConfigurableApplicationContext configServer;

    @BeforeClass
    public static void startConfigServer() throws Exception {
        String baseDir = ConfigServerTestUtils.getBaseDirectory(".");
        String repo = ConfigServerTestUtils.prepareLocalRepo(baseDir, "target/repos", "config-repo", "target/config");
        int configServerPort = 0;
        configServer = SpringApplication.run(ConfigServerApplication.class,
                String.format("--server.port=%d", configServerPort),
                String.format("--spring.cloud.config.server.git.uri=%s", repo));
        configServerPort = ((EmbeddedWebApplicationContext) configServer).getEmbeddedServletContainer().getPort();
        System.setProperty("config.port", String.valueOf(configServerPort));
    }

    @AfterClass
    public static void close() {
        System.clearProperty("config.port");
        if (configServer != null) {
            configServer.close();
        }
    }

    @Test
    public void testHello() {
        String url = String.format("http://localhost:%d/hello/Gregor", port);
        String json = new TestRestTemplate().getForObject(url, String.class);
        assertEquals("Hi Gregor!", JsonPath.read(json, "$.message"));
    }

}
