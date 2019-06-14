package com.distributor.controls.interfaces;

import com.distributor.dtos.DrinkDto;
import com.distributor.entities.Drink;

import java.util.List;

public interface IDrinkDtoManager {
    void persistDrink();
    List<DrinkDto> getDrinkDtoByCode(String code);
    List<Drink> getDrinkByCode(String code);
    List<DrinkDto> getDrinkDtos();
}
