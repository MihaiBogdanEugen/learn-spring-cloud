package ro.mbe.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SecureServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecureServiceApplication.class, args);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "Secure Service";
    }
}
