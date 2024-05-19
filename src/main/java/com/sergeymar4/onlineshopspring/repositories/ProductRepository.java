package com.sergeymar4.onlineshopspring.repositories;

import com.sergeymar4.onlineshopspring.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
