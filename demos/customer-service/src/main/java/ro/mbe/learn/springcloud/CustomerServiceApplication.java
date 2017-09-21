package ro.mbe.learn.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "Customer Service";
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate webTemplate;

    @RequestMapping(value="/customer/{cid}", method=RequestMethod.GET)
    public @ResponseBody
    String getCustomer(@PathVariable Integer cid) {

        ResponseEntity<String> contact = webTemplate.getForEntity("http://localhost:9005/fastpass/customer/"+cid+"/contactdetails", String.class);
        ResponseEntity<String> vehicle = webTemplate.getForEntity("http://localhost:9006/fastpass/customer/"+cid+"/vehicledetails", String.class);

        return contact.getBody() + " | " + vehicle.getBody();
    }
}
