package com.distributor.dtos;

import com.distributor.models.DrinkJson;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;

@Immutable
public class DistributorLineDto implements Serializable {

    private Long id;
    private int amount;
    private DrinkJson drinkJson;

    public DistributorLineDto() {
    }

    public DistributorLineDto(Long id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public DrinkJson getDrinkJson() {
        return drinkJson;
    }

    public void setDrinkJson(DrinkJson drinkJson) {
        this.drinkJson = drinkJson;
    }
}
