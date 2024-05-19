package com.sergeymar4.onlineshopspring.services;

import com.sergeymar4.onlineshopspring.models.Basket;
import com.sergeymar4.onlineshopspring.models.Product;
import com.sergeymar4.onlineshopspring.repositories.BasketRepository;
import com.sergeymar4.onlineshopspring.repositories.CustomerRepository;
import com.sergeymar4.onlineshopspring.repositories.ProductRepository;
import com.sergeymar4.onlineshopspring.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ShopRepository shopRepository;

    public List<Basket> getAll() {
        return basketRepository.findAll();
    }

    public Basket getById(Long id) {
        return basketRepository.findById(id).get();
    }

    public void create(Basket basket) {
        basket.setCustomer(customerRepository.findById(basket.getCustomer().getId()).get());
        basket.setShop(shopRepository.findById(basket.getShop().getId()).get());
        basketRepository.save(basket);
    }

    public void update(Basket basket) {
        Basket oldBasket = basketRepository.findById(basket.getId()).get();

        if (basket.getCustomer() != null) {
            oldBasket.setCustomer(customerRepository.findById(basket.getCustomer().getId()).get());
        }
        if (basket.getShop() != null) {
            oldBasket.setShop(shopRepository.findById(basket.getShop().getId()).get());
        }
        if (basket.getProducts() != null) {
            List<Product> products = new ArrayList<>();

            for (Product product : basket.getProducts()) {
                products.add(productRepository.findById(product.getId()).get());
            }

            oldBasket.setProducts(products);
        }

        basketRepository.save(oldBasket);
    }

    public void delete(Long id) {
        basketRepository.delete(basketRepository.findById(id).get());
    }
}
