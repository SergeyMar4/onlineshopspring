package com.sergeymar4.onlineshopspring.controllers;

import com.sergeymar4.onlineshopspring.models.Customer;
import com.sergeymar4.onlineshopspring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody Customer customer) {
        customerService.create(customer);
    }

    @PutMapping
    public void update(@RequestBody Customer customer) {
        customerService.update(customer);
    }

    @DeleteMapping("/{id}")
    public  void delete(@PathVariable Long id) {
        customerService.delete(id);
    }
}
