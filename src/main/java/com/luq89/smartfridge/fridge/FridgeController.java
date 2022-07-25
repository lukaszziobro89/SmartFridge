package com.luq89.smartfridge.fridge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/fridges")
public class FridgeController {

    private final FridgeService service;

    @Autowired
    public FridgeController(FridgeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Fridge>> showAllFridges(){
        List<Fridge> fridges = service.getAvailableFridges();
        return new ResponseEntity<>(fridges, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Fridge> createTutorial(@RequestBody Fridge fridge) {
        try {
            Fridge _fridge = service.createFridge(
                    new Fridge(fridge.getProducerName(), fridge.getDoorType(), fridge.getFridgeName()));
            return new ResponseEntity<>(_fridge, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
