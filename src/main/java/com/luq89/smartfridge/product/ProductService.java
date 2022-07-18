package com.luq89.smartfridge.product;

import com.luq89.smartfridge.fridge.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FridgeRepository fridgeRepository;

    public Product addProductToFridge(Product product){
        return productRepository.save(product);
    }

}
