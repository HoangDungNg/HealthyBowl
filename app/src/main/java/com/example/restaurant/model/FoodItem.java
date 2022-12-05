package com.example.restaurant.model;

public class FoodItem {
    String name, ingredient, price;
    Integer food_imageUrl;

    public FoodItem(String name, String ingredient, String price, Integer food_imageUrl) {
        this.name = name;
        this.ingredient = ingredient;
        this.price = price;
        this.food_imageUrl = food_imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getFood_imageUrl() {
        return food_imageUrl;
    }

    public void setFood_imageUrl(Integer food_imageUrl) {
        this.food_imageUrl = food_imageUrl;
    }
}
