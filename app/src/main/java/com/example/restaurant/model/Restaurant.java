package com.example.restaurant.model;
import java.util.List;

public class Restaurant {
    String name;
    String introduction;
    String address;
    String phone;
    String cate_food;
    Integer restaurant_imageUrl;

    public Restaurant(String name, String introduction, String address, String phone, String cate_food , Integer restaurant_imageUrl) {
        this.name = name;
        this.introduction = introduction;
        this.address = address;
        this.phone = phone;
        this.cate_food = cate_food;
        this.restaurant_imageUrl = restaurant_imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCate_food() {
        return cate_food;
    }

    public void setCate_food(String cate_food) {
        this.cate_food = cate_food;
    }

    public Integer getRestaurant_imageUrl() {
        return restaurant_imageUrl;
    }

    public void setRestaurant_imageUrl(Integer restaurant_imageUrl) {
        this.restaurant_imageUrl = restaurant_imageUrl;
    }
}
