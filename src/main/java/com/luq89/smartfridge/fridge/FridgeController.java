package com.luq89.smartfridge.fridge;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

// TODO: add logging

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/fridges")
public class FridgeController {

    private final FridgeService service;
    private final ModelMapper modelMapper;

    @Autowired
    public FridgeController(FridgeService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<FridgeDTO>> showAllFridges(){
        List<Fridge> fridges = service.getAvailableFridges();
        List<FridgeDTO> fridgeDTOList = fridges.stream()
                .map(fridge -> modelMapper.map(fridge, FridgeDTO.class))
                .toList();
        return new ResponseEntity<>(fridgeDTOList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<FridgeDTO> createTutorial(@RequestBody FridgeDTO fridgeDTO) {
        try {
            Fridge fridge = modelMapper.map(fridgeDTO, Fridge.class);
            Fridge fridgeCreated = service.createFridge(fridge);
            FridgeDTO fridgeCreatedDTO = modelMapper.map(fridgeCreated, FridgeDTO.class);
            return new ResponseEntity<>(fridgeCreatedDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
