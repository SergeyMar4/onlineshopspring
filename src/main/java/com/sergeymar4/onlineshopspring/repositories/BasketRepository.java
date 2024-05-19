package com.sergeymar4.onlineshopspring.repositories;

import com.sergeymar4.onlineshopspring.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {

}
