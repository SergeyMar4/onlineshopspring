package com.sergeymar4.onlineshopspring.services;

import com.sergeymar4.onlineshopspring.models.Product;
import com.sergeymar4.onlineshopspring.repositories.ManufacturerRepository;
import com.sergeymar4.onlineshopspring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    public void create(Product product) {
        product.setManufacturer(manufacturerRepository.findById(product.getManufacturer().getId()).get());
        productRepository.save(product);
    }

    public void update(Product product) {
        Product oldProduct = productRepository.findById(product.getId()).get();

        if (product.getTitle() != null) {
            oldProduct.setTitle(product.getTitle());
        }

        if (product.getPrice() != 0) {
            oldProduct.setPrice(product.getPrice());
        }

        if (product.getManufacturer() != null) {
            oldProduct.setManufacturer(manufacturerRepository.findById(product.getManufacturer().getId()).get());
        }

        productRepository.save(oldProduct);
    }

    public void delete(Long id) {
        productRepository.delete(productRepository.findById(id).get());
    }
}
