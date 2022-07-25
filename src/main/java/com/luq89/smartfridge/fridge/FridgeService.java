package com.luq89.smartfridge.fridge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: add logging
@Service
public class FridgeService {

    private final FridgeRepository fridgeRepository;

    @Autowired
    public FridgeService(FridgeRepository fridgeRepository) {
        this.fridgeRepository = fridgeRepository;
    }

    public List<Fridge> getAvailableFridges() {
        return fridgeRepository.findAll();
    }

    public Fridge getFridgeById(Long fridgeId) throws Exception {
        return fridgeRepository.findById(fridgeId).orElseThrow(Exception::new);
    }

    public Fridge createFridge(Fridge fridge) {
        return fridgeRepository.save(fridge);
    }
}
