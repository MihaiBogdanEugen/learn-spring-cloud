package ro.mbe.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.Random;

@SpringBootApplication
@RestController
public class DataService1Application {

    public static void main(String[] args) {
        SpringApplication.run(DataService1Application.class, args);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "Data Service #1";
    }

    @RequestMapping(value="/customer/{cid}/contactdetails", method=RequestMethod.GET)
    public @ResponseBody String getCustomerContactDetails(@PathVariable Integer cid) throws InterruptedException {

        //add arbitrary latency
        Random r = new Random();
        int multiplier = r.nextInt(5) * 1000;
        System.out.println("multiplier: " + multiplier);
        Thread.sleep(multiplier);


        Hashtable<Integer, String> customers = new Hashtable<>();
        customers.put(100, "Beverly Goldberg");
        customers.put(101, "Dave Kim");
        customers.put(102, "Lainey Lewis");

        return customers.get(cid);
    }
}
