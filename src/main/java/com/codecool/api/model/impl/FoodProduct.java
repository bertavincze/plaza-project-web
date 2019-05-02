package com.codecool.api.model.impl;

import com.codecool.api.model.Product;

import java.util.Date;

public class FoodProduct extends Product {

    private int calories;
    private Date bestBefore;

    public FoodProduct(long barcode, String name, String manufacturer, int calories, Date bestBefore) {
        super(barcode, name, manufacturer);
        this.calories = calories;
        this.bestBefore = bestBefore;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isStillConsumable() {
        Date date = new Date();
        long time = date.getTime();
        long expiryDate = this.bestBefore.getTime();
        return expiryDate < time;
    }

    public Date getBestBefore() {
        return bestBefore;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
