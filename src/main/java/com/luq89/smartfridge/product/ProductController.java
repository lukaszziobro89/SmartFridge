package com.luq89.smartfridge.product;

import com.luq89.smartfridge.fridge.Fridge;
import com.luq89.smartfridge.fridge.FridgeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private FridgeService fridgeService;

//    TODO: move
//     @Autowired to constructor

    @GetMapping("/add")
    public String displayFridgeForm(Model model){
        model.addAttribute("fridges", fridgeService.getAvailableFridges());
        model.addAttribute("product", new Product());
        model.addAttribute("fridge", new Fridge());
        return "product/addProduct";
    }


    @PostMapping("/create/{id}")
    public String addProductToFridge(@ModelAttribute Product product,
                                     @RequestParam(value = "id") Long id) throws Exception {
        product.setFridge(fridgeService.getFridgeById(id));
        productService.addProductToFridge(product);
        log.info("Product '" + product.getProductName() + "' added to fridge with id: " + id);
        return "redirect:/product/add";
    }
}
