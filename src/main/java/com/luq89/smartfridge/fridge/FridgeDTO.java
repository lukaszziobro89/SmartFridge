package com.luq89.smartfridge.fridge;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FridgeDTO {

    private String producerName;
    private DoorType doorType;
    private String fridgeName;
    private double freezerCapacity;
    private double chillerCapacity;

}
