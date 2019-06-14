package com.distributor.controls.converters;

import com.distributor.controls.motherclasses.DrinkManagerImpl;
import com.distributor.dtos.DrinkDto;
import com.distributor.entities.Drink;

public class DrinkConverter extends DrinkManagerImpl {

    private static DrinkDto drinkDto;

    public DrinkConverter() {}

    public static DrinkDto getDrinkDto(Drink drink) {
        drinkDto = new DrinkDto();
        drinkDto.setId(drink.getId());
        drinkDto.setCode(drink.getCode());
        drinkDto.setName(drink.getName());
        return drinkDto;
    }
}
