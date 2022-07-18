package com.luq89.smartfridge.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(){
        return "index";
    }

    @GetMapping("/button")
    public String aboutPage(){
        return "bc_button";
    }

}
