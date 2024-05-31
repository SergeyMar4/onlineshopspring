package com.sergeymar4.onlineshopspring.dto;

import com.sergeymar4.onlineshopspring.models.Manufacturer;

public class ManufacturerMapper {
    public static ManufacturerDTO toDTO(Manufacturer manufacturer) {
        ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
        manufacturerDTO.setId(manufacturer.getId());
        manufacturerDTO.setTitle(manufacturer.getTitle());
        manufacturerDTO.setCountry(manufacturer.getCountry());

        return manufacturerDTO;
    }

    public static Manufacturer toEntity(ManufacturerDTO manufacturerDTO) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(manufacturer.getId());
        manufacturer.setTitle(manufacturerDTO.getTitle());
        manufacturer.setCountry(manufacturerDTO.getCountry());

        return manufacturer;
    }
}
