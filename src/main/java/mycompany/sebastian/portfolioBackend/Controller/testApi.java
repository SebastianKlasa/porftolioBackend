package mycompany.sebastian.portfolioBackend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testApi {

    @GetMapping("/testapi1")
    public String test1(){
        return "testapi1";
    }
    @GetMapping("/test2")
    public String test2(){
        return "test2";
    }
    @GetMapping("/test3")
    public String test3(){
        return "test3";
    }

}
