package com.sergeymar4.onlineshopspring.services;

import com.sergeymar4.onlineshopspring.models.Manufacturer;
import com.sergeymar4.onlineshopspring.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer getById(Long id) {
        return manufacturerRepository.findById(id).get();
    }

    public void create(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    public void update(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    public void delete(Long id) {
        manufacturerRepository.delete(manufacturerRepository.findById(id).get());
    }
}
