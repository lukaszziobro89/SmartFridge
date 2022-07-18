package com.luq89.smartfridge.product;

import com.luq89.smartfridge.fridge.Fridge;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "fridge_id")
    private Fridge fridge;

    public Product() {}

    public Product(String productName, Fridge fridge){
        super();
        this.productName = productName;
        this.fridge = fridge;
    }
}
