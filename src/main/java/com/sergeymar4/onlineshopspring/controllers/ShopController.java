package com.sergeymar4.onlineshopspring.controllers;

import com.sergeymar4.onlineshopspring.dto.ShopDTO;
import com.sergeymar4.onlineshopspring.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(shopService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(shopService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ShopDTO shop) {
        shopService.create(shop);

        return new ResponseEntity<>("Объект успешно создан", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ShopDTO shop) {
        shopService.update(shop);

        return new ResponseEntity<>("Объект успешно обновлён", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        shopService.delete(id);

        return new ResponseEntity<>("Объект успешно удалён", HttpStatus.OK);
    }
}
