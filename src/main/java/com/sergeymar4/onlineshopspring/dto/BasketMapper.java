package com.sergeymar4.onlineshopspring.dto;

import com.sergeymar4.onlineshopspring.models.Basket;
import com.sergeymar4.onlineshopspring.models.Product;
import com.sergeymar4.onlineshopspring.services.BasketService;
import com.sergeymar4.onlineshopspring.services.CustomerService;
import com.sergeymar4.onlineshopspring.services.ProductService;
import com.sergeymar4.onlineshopspring.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BasketMapper {
    @Autowired
    private static CustomerService customerService;
    @Autowired
    private static ShopService shopService;
    @Autowired
    private static ProductService productService;

    public static BasketDTO toDTO(Basket basket) {
        BasketDTO basketDTO = new BasketDTO();
        basketDTO.setId(basket.getId());
        basketDTO.setCustomer(CustomerMapper.toDTO(basket.getCustomer()));
        basketDTO.setShop(ShopMapper.toDTO(basket.getShop()));
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : basket.getProducts()) {
            productDTOList.add(ProductMapper.toDTO(product));
        }

        basketDTO.setProductList(productDTOList);

        return basketDTO;
    }

    public static Basket toEntity(BasketDTO basketDTO) {
        Basket basket = new Basket();
        System.out.println(basketDTO.toString());
        basket.setId(basketDTO.getId());
        basket.setCustomer(customerService.getById(basketDTO.getCustomerDTO().getId()));
        basket.setShop(ShopMapper.toEntity(shopService.getById(basketDTO.getShopDTO().getId())));
        List<Product> productList = new ArrayList<>();

        for (ProductDTO product : basketDTO.getProductDTOList()) {
            productList.add(productService.getById(product.getId()));
        }

        basket.setProducts(productList);

        return basket;
    }
}
