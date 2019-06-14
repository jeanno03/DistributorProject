package com.distributor.controls.implementations;

import com.distributor.controls.interfaces.IDrinkDtoManager;
import com.distributor.controls.converters.DrinkConverter;
import com.distributor.dtos.DrinkDto;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class DrinkDtoManagerImpl extends DrinkConverter implements IDrinkDtoManager {

    @PersistenceContext(unitName = "distributorDB")
    EntityManager em;

    private static List<DrinkDto> drinkDtos;

    public DrinkDtoManagerImpl() {
    }

    private void initDrinkDtos(){
        drinkDtos= new ArrayList<>();
    }

    @Override
    public List<DrinkDto> getDrinkDtoByCode(String code){
        initDrinkDtos();
        getDrinkByCode(code); //works return List of Drink need only(0)
        drinkDtos.add(getDrinkDto(getDrinkByCode(code).get(0)));
        return drinkDtos;
    }

    @Override
    public List<DrinkDto> getDrinkDtos(){
        initDrinkDtos();
        getDrinks().forEach(d->{
            drinkDtos.add(getDrinkDto(d));
        });
            return drinkDtos;
    }

}
