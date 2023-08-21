package TM.CoordinationOffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    @RequestMapping(value={"","/","/index"},name = "The main page")
    public String index() { return "th/home/index"; }
}
