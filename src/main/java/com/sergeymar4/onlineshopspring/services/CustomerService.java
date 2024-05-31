package com.sergeymar4.onlineshopspring.services;

import com.sergeymar4.onlineshopspring.models.Customer;
import com.sergeymar4.onlineshopspring.models.Basket;
import com.sergeymar4.onlineshopspring.repositories.BasketRepository;
import com.sergeymar4.onlineshopspring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BasketRepository basketRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getById(Long id) {
        return customerRepository.findById(id).get();
    }

    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    public void update(Customer customer) {
        Customer oldCustomer = customerRepository.findById(customer.getId()).get();

        if (customer.getAge() != 0) {
            oldCustomer.setAge(customer.getAge());
        }
        if (customer.getName() != null) {
            oldCustomer.setName(customer.getName());
        }
        if (customer.getSurname() != null) {
            oldCustomer.setSurname(customer.getSurname());
        }
        if (customer.getMoney() != 0) {
            oldCustomer.setMoney(customer.getMoney());
        }
        if (customer.getBaskets() != null) {
            for (Basket basket : customer.getBaskets()) {
                Basket basket1 = basketRepository.findById(basket.getId()).get();
                basket1.setCustomer(customerRepository.findById(customer.getId()).get());
                basketRepository.save(basket1);
            }
        }

        customerRepository.save(oldCustomer);
    }

    public void delete(Long id) {
        customerRepository.delete(customerRepository.findById(id).get());
    }
}
