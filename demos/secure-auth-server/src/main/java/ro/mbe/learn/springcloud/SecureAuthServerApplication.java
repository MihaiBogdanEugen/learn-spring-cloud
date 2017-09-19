package ro.mbe.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
public class SecureAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecureAuthServerApplication.class, args);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "Secure Auth Server";
    }
}
