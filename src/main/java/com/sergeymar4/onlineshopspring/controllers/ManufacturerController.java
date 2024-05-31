package com.sergeymar4.onlineshopspring.controllers;

import com.sergeymar4.onlineshopspring.dto.ManufacturerDTO;
import com.sergeymar4.onlineshopspring.models.Manufacturer;
import com.sergeymar4.onlineshopspring.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(manufacturerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(manufacturerService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ManufacturerDTO manufacturer) {
        manufacturerService.create(manufacturer);

        return new ResponseEntity<>("Объект успешно создан", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ManufacturerDTO manufacturer) {
        manufacturerService.update(manufacturer);
        return new ResponseEntity<>("Обект успешно обновлён", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        manufacturerService.delete(id);

        return new ResponseEntity<>("Объект успешно удалён", HttpStatus.OK);
    }
}
