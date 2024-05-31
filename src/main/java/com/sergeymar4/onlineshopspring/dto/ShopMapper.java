package com.sergeymar4.onlineshopspring.dto;

import com.sergeymar4.onlineshopspring.models.Shop;

public class ShopMapper {
    public static ShopDTO toDTO(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setId(shop.getId());
        shopDTO.setTitle(shop.getTitle());

        return shopDTO;
    }

    public static Shop toEntity(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setId(shopDTO.getId());
        shop.setTitle(shopDTO.getTitle());

        return shop;
    }
}
