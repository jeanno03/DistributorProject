package com.distributor.models;

import com.distributor.entities.Drink;

import java.io.Serializable;

public class DrinkJson implements Serializable {

    private Drink drink;
    private float price;

    public DrinkJson() {
        super();
    }

    public DrinkJson(Drink drink, float price) {
        this.drink = drink;
        this.price = price;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
