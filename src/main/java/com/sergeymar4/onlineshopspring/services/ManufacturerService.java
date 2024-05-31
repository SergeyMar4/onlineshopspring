package com.sergeymar4.onlineshopspring.services;

import com.sergeymar4.onlineshopspring.dto.ManufacturerDTO;
import com.sergeymar4.onlineshopspring.dto.ManufacturerMapper;
import com.sergeymar4.onlineshopspring.dto.ShopDTO;
import com.sergeymar4.onlineshopspring.dto.ShopMapper;
import com.sergeymar4.onlineshopspring.models.Manufacturer;
import com.sergeymar4.onlineshopspring.models.Shop;
import com.sergeymar4.onlineshopspring.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<ManufacturerDTO> getAll() {
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        List<ManufacturerDTO> manufacturerDTOs = new ArrayList<>();

        for (Manufacturer manufacturer : manufacturers) {
            manufacturerDTOs.add(ManufacturerMapper.toDTO(manufacturer));
        }

        return manufacturerDTOs;
    }

    public ManufacturerDTO getById(Long id) {
        ManufacturerDTO manufacturerDTO = null;

        try {
            manufacturerDTO = ManufacturerMapper.toDTO(manufacturerRepository.findById(id).orElseThrow(() -> new RuntimeException("Не найдено")));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return manufacturerDTO;
    }

    public void create(ManufacturerDTO manufacturerDTO) {
        manufacturerRepository.save(ManufacturerMapper.toEntity(manufacturerDTO));
    }

    public void update(ManufacturerDTO manufacturerDTO) {
        Manufacturer oldManufacturer = manufacturerRepository.findById((manufacturerDTO.getId())).get();
        Manufacturer manufacturer = ManufacturerMapper.toEntity(manufacturerDTO);

        if (manufacturer.getTitle() != null) {
            oldManufacturer.setTitle(manufacturer.getTitle());
        }

        if (manufacturer.getCountry() != null) {
            oldManufacturer.setCountry(manufacturer.getCountry());
        }

        manufacturerRepository.save(oldManufacturer);
    }

    public void delete(Long id) {
        manufacturerRepository.delete(manufacturerRepository.findById(id).get());
    }
}
