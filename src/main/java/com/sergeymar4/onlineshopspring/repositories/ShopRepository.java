package com.sergeymar4.onlineshopspring.repositories;

import com.sergeymar4.onlineshopspring.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {

}
