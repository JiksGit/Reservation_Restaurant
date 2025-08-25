package com.sinse.restaurant.controller;

import com.sinse.restaurant.domain.Store;
import com.sinse.restaurant.model.store.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestParam String name, @RequestParam String location) {
        Store store = storeService.createStore(name, location);
        return ResponseEntity.ok(store);
    }

    @GetMapping
    public List<Store> getStores() {
        return storeService.findAllStores();
    }
}
