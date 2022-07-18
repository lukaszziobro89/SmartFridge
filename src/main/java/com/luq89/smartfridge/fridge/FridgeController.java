package com.luq89.smartfridge.fridge;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fridge")
public class FridgeController {

    @GetMapping("/add")
    public String displayAddFridgeForm(){
        return "fridge/add-fridge";
    }
}
