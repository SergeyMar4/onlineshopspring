package com.sergeymar4.onlineshopspring.services;

import com.sergeymar4.onlineshopspring.dto.ShopDTO;
import com.sergeymar4.onlineshopspring.dto.ShopMapper;
import com.sergeymar4.onlineshopspring.models.Shop;
import com.sergeymar4.onlineshopspring.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public List<ShopDTO> getAll() {
        List<Shop> shops = shopRepository.findAll();
        List<ShopDTO> shopDTOs = new ArrayList<>();

        for (Shop shop : shops) {
            shopDTOs.add(ShopMapper.toDTO(shop));
        }

        return shopDTOs;
    }

    public ShopDTO getById(Long id) {
        ShopDTO shopDTO = null;

        try {
            shopDTO = ShopMapper.toDTO(shopRepository.findById(id).orElseThrow(() -> new RuntimeException("Не найдено")));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return shopDTO;
    }

    public void create(ShopDTO shopDTO) {
        shopRepository.save(ShopMapper.toEntity(shopDTO));
    }

    public void update(ShopDTO shopDTO) {
        Shop oldShop = shopRepository.findById((shopDTO.getId())).get();
        Shop shop = ShopMapper.toEntity(shopDTO);

        if (shop.getTitle() != null) {
            oldShop.setTitle(shop.getTitle());
        }

        shopRepository.save(oldShop);
    }

    public void delete(Long id) {
        shopRepository.delete(shopRepository.findById(id).get());
    }
}
