package ro.mbe.learn.springcloud.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RateController {

    @Value("${rate}")
    private String rate;

    @Value("${lanecount}")
    private String laneCount;

    @Value("${tollstart}")
    private String tollStart;

    @RequestMapping("/rate")
    public String getRate(Model model) {

        model.addAttribute("rate", this.rate);
        model.addAttribute("laneCount", this.laneCount);
        model.addAttribute("tollStart", this.tollStart);

        return "rateview";
    }
}
