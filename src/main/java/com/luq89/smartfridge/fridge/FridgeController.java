package com.luq89.smartfridge.fridge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/fridges")
public class FridgeController {

    @Autowired
    private FridgeService service;

    @GetMapping("/")
    public String showAllFridges(Model model){
        model.addAttribute("fridges", service.getAvailableFridges());
        return "fridge/fridges";
    }

    @GetMapping("/add")
    public String displayFridgeForm(Model model){
        Fridge aFridge = new Fridge();
        model.addAttribute("fridge", aFridge);
        model.addAttribute("doorTypes", DoorType.values());
        return "fridge/addFridge";
    }

    @PostMapping("/create")
    public String createFridge(Fridge fridge){
        service.createFridge(fridge);
        log.info("Fridge with id: " + fridge.getId() + " fridge registered.");
        return "redirect:/fridges/add";
    }
}
