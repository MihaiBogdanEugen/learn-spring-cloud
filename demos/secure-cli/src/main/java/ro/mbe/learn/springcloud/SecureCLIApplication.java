package ro.mbe.learn.springcloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class SecureCLIApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SecureCLIApplication.class, args);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "Secure CLI";
    }

    @Override
    public void run(String... arg0) throws Exception {

        System.out.println("cron job started");

        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
        resourceDetails.setAccessTokenUri("http://localhost:1231/services/oauth/token");

        //must be a valid scope or get an error; if empty, get all scopes (default); better to ask for one
        resourceDetails.setScope(Arrays.asList("toll_read"));

        //must be valid client id or get an error
        resourceDetails.setClientId("pluralsight");
        resourceDetails.setClientSecret("pluralsightsecret");

        //diff user results in diff authorities/roles coming out; preauth on roles fails for adam, works for barry
        resourceDetails.setUsername("user1");
        resourceDetails.setPassword("password1");

        OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails);
        //could also get scopes: template.getAccessToken().getScope()
        String token =  template.getAccessToken().toString();//.getValue();

        System.out.println("Token: " + token);

        String s = template.getForObject("http://localhost:1233/services/tolldata", String.class);

        System.out.println("Result: " + s);
    }
}
