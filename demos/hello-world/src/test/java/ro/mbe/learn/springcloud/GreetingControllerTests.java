package ro.mbe.learn.springcloud;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ro.mbe.learn.springcloud.models.Greeting;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerTests {

    @LocalServerPort
    private int port;

    private URL defaultBase;
    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.defaultBase = new URL("http://localhost:" + port + "/greeting");
        this.base = new URL("http://localhost:" + port + "/greeting?name=");
    }

    @Test
    public void defaultGreetingRouteWorks() throws Exception {

        ResponseEntity<Greeting> firstResponse = this.template.getForEntity(this.defaultBase.toString(), Greeting.class);
        assertThat(firstResponse.getStatusCode().value(), equalTo(200));
        Greeting firstGreeting = firstResponse.getBody();
        assertThat(firstGreeting.getContent(), equalTo("Hello, World!"));

        ResponseEntity<Greeting> secondResponse = this.template.getForEntity(this.defaultBase.toString(), Greeting.class);
        assertThat(secondResponse.getStatusCode().value(), equalTo(200));
        Greeting secondGreeting = secondResponse.getBody();
        assertThat(secondGreeting.getContent(), equalTo("Hello, World!"));

        assertThat(secondGreeting.getId(), equalTo(firstGreeting.getId() + 1));
    }

    @Test
    public void greetingRouteWorks() throws Exception {

        final String name = "Bogdan";

        ResponseEntity<Greeting> firstResponse = this.template.getForEntity(this.base.toString() + name, Greeting.class);
        assertThat(firstResponse.getStatusCode().value(), equalTo(200));
        Greeting firstGreeting = firstResponse.getBody();
        assertThat(firstGreeting.getContent(), equalTo(String.format("Hello, %s!", name)));

        ResponseEntity<Greeting> secondResponse = this.template.getForEntity(this.base.toString() + name, Greeting.class);
        assertThat(secondResponse.getStatusCode().value(), equalTo(200));
        Greeting secondGreeting = secondResponse.getBody();
        assertThat(secondGreeting.getContent(), equalTo(String.format("Hello, %s!", name)));

        assertThat(secondGreeting.getId(), equalTo(firstGreeting.getId() + 1));
    }
}
