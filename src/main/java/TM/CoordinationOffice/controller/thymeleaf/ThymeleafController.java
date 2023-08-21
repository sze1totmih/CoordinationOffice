package TM.CoordinationOffice.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("th")
public class ThymeleafController {
    @RequestMapping(value ={"","/", "/index"}, name = "Thymeleaf web page home")
    public String index() { return "th/home/th/index";}
}
