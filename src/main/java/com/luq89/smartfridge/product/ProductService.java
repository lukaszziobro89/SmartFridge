package com.luq89.smartfridge.product;

import com.luq89.smartfridge.fridge.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final FridgeRepository fridgeRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, FridgeRepository fridgeRepository) {
        this.productRepository = productRepository;
        this.fridgeRepository = fridgeRepository;
    }

    public Product addProductToFridge(Product product){
        return productRepository.save(product);
    }

}
