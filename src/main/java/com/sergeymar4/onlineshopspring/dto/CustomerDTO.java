package com.sergeymar4.onlineshopspring.dto;

import com.sergeymar4.onlineshopspring.models.Basket;

import java.util.List;

public class CustomerDTO {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private int money;
    private List<Long> basketIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Long> getBasketIds() {
        return basketIds;
    }

    public void setBasketList(List<Long> basketIds) {
        this.basketIds = basketIds;
    }
}
