package com.sergeymar4.onlineshopspring.dto;

import com.sergeymar4.onlineshopspring.models.Customer;
import com.sergeymar4.onlineshopspring.models.Product;
import com.sergeymar4.onlineshopspring.models.Shop;

import java.util.List;

public class BasketDTO {
    private Long id;
    private CustomerDTO customerDTO;
    private ShopDTO shopDTO;
    private List<ProductDTO> productDTOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomer(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public ShopDTO getShopDTO() {
        return shopDTO;
    }

    public void setShop(ShopDTO shopDTO) {
        this.shopDTO = shopDTO;
    }

    public List<ProductDTO> getProductDTOList() {
        return productDTOList;
    }

    public void setProductList(List<ProductDTO> productDTOList) {
        this.productDTOList = productDTOList;
    }

    @Override
    public String toString() {
        return "BasketDTO{" +
                "id=" + id +
                ", customerDTO=" + customerDTO +
                ", shopDTO=" + shopDTO +
                ", productDTOList=" + productDTOList +
                '}';
    }
}
