package com.sergeymar4.onlineshopspring.services;

import com.sergeymar4.onlineshopspring.models.Shop;
import com.sergeymar4.onlineshopspring.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    public Shop getById(Long id) {
        return shopRepository.findById(id).get();
    }

    public void create(Shop shop) {
        shopRepository.save(shop);
    }

    public void update(Shop shop) {
        Shop oldShop = shopRepository.findById((shop.getId())).get();

        if (shop.getTitle() != null) {
            oldShop.setTitle(shop.getTitle());
        }
        shopRepository.save(shop);
    }

    public void delete(Long id) {
        shopRepository.delete(shopRepository.findById(id).get());
    }
}
