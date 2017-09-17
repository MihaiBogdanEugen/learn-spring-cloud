package ro.mbe.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello from String Boot!";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "Hello World";
    }
}
