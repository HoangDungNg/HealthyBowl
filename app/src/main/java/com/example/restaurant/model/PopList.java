package com.example.restaurant.model;

public class PopList {

    Integer id;
    Integer pop_imageUrl;

    public PopList(Integer id, Integer pop_imageUrl) {
        this.id = id;
        this.pop_imageUrl = pop_imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPop_imageUrl() {
        return pop_imageUrl;
    }

    public void setPop_imageUrl(Integer pop_imageUrl) {
        this.pop_imageUrl = pop_imageUrl;
    }




}
