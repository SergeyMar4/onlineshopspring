package com.sergeymar4.onlineshopspring.repositories;

import com.sergeymar4.onlineshopspring.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
