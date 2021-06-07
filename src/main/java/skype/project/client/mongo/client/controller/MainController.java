package skype.project.client.mongo.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MainController {

    @GetMapping("/main")
    public String findAll(){
        return "main";
    }
}
