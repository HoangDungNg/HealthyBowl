package com.example.restaurant.model;

public class CategoryItem {
    Integer id;
    Integer imageUrl;
    String txt;

    public CategoryItem(Integer id, Integer imageUrl, String txt) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.txt = txt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
