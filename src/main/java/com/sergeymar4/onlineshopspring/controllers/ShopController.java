package com.sergeymar4.onlineshopspring.controllers;

import com.sergeymar4.onlineshopspring.models.Shop;
import com.sergeymar4.onlineshopspring.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping
    public List<Shop> getAll() {
        return shopService.getAll();
    }

    @GetMapping("/{id}")
    public Shop getById(@PathVariable Long id) {
        return shopService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody Shop shop) {
        shopService.create(shop);
    }

    @PutMapping
    public void update(@RequestBody Shop shop) {
        shopService.update(shop);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        shopService.delete(id);
    }
}
