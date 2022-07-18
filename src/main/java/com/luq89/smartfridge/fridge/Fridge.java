package com.luq89.smartfridge.fridge;

import com.luq89.smartfridge.product.Product;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Fridge")
@Getter
@Setter
public class Fridge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String producerName;
    @Enumerated(EnumType.STRING)
    private DoorType doorType;
    private String fridgeName;

    @OneToMany(mappedBy = "fridge", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    public Fridge() {}

    public Fridge(String producerName, String doorType) {
        super();
        this.producerName = producerName;
        this.doorType = DoorType.valueOf(doorType);
    }

    public Fridge(String producerName, DoorType doorType, String fridgeName) {
        this.producerName = producerName;
        this.doorType = doorType;
        this.fridgeName = fridgeName;
    }
}
