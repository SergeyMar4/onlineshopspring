package com.sergeymar4.onlineshopspring.controllers;

import com.sergeymar4.onlineshopspring.dto.BasketDTO;
import com.sergeymar4.onlineshopspring.models.Basket;
import com.sergeymar4.onlineshopspring.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baskets")
public class BasketController {
    @Autowired
    private BasketService basketService;

    @GetMapping
    public List<BasketDTO> getAll() {
        return basketService.getAll();
    }

    @GetMapping("/{id}")
    public BasketDTO getById(@PathVariable Long id) {
        return basketService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody BasketDTO basket) {
        basketService.create(basket);
    }

    @PutMapping
    public void update(@RequestBody Basket basket) {
        basketService.update(basket);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        basketService.delete(id);
    }
}
