package com.sergeymar4.onlineshopspring.dto;

import com.sergeymar4.onlineshopspring.models.Product;

public class ProductMapper {
    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setPrice(product.getPrice());
        productDTO.setManufacturerDTO(ManufacturerMapper.toDTO(product.getManufacturer()));

        return productDTO;
    }

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setManufacturer(ManufacturerMapper.toEntity(productDTO.getManufacturerDTO()));

        return product;
    }
}
