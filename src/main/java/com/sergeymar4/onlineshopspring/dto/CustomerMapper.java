package com.sergeymar4.onlineshopspring.dto;

import com.sergeymar4.onlineshopspring.models.Basket;
import com.sergeymar4.onlineshopspring.models.Customer;
import com.sergeymar4.onlineshopspring.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {
    @Autowired
    private static BasketService basketService;

    public static CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customer.setSurname(customer.getSurname());
        customer.setAge(customer.getAge());
        customer.setMoney(customer.getMoney());
        List<Long> basketDTOIds = new ArrayList<>();

        for (Basket basket : customer.getBaskets()) {
            basketDTOIds.add(basket.getId());
        }

        customerDTO.setBasketList(basketDTOIds);

        return customerDTO;
    }

    public static Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setAge(customerDTO.getAge());
        customer.setMoney(customerDTO.getMoney());
        List<Basket> basketList = new ArrayList<>();

        for (Long basketId : customerDTO.getBasketIds()) {
            basketList.add(BasketMapper.toEntity(basketService.getById(basketId)));
        }

        customer.setBaskets(basketList);

        return customer;
    }
}
