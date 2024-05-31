package com.sergeymar4.onlineshopspring.services;

import com.sergeymar4.onlineshopspring.dto.BasketDTO;
import com.sergeymar4.onlineshopspring.dto.BasketMapper;
import com.sergeymar4.onlineshopspring.dto.CustomerMapper;
import com.sergeymar4.onlineshopspring.dto.ShopMapper;
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

    public List<BasketDTO> getAll() {
        List<Basket> baskets = basketRepository.findAll();
        List<BasketDTO> basketDTOList = new ArrayList<>();

        for (Basket basket : baskets) {
            basketDTOList.add(BasketMapper.toDTO(basket));
        }

        return basketDTOList;
    }

    public BasketDTO getById(Long id) {
        BasketDTO basketDTO = null;

        try {
            basketDTO = BasketMapper.toDTO(basketRepository.findById(id).orElseThrow(() -> new RuntimeException("Не найдено")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return basketDTO;
    }

    public void create(BasketDTO basketDTO) {
        basketDTO.setCustomer(CustomerMapper.toDTO(customerRepository.findById(basketDTO.getCustomerDTO().getId()).get()));
        basketDTO.setShop(ShopMapper.toDTO(shopRepository.findById(basketDTO.getShopDTO().getId()).get()));
        basketRepository.save(BasketMapper.toEntity(basketDTO));
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
