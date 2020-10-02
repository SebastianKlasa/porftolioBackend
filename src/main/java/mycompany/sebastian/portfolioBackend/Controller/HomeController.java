package mycompany.sebastian.portfolioBackend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/project")
    public String project() {
        return "project";
    }

}
