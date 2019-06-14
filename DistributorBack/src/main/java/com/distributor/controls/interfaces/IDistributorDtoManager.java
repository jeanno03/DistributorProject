package com.distributor.controls.interfaces;

import com.distributor.dtos.DistributorDto;
import com.distributor.dtos.DrinkDto;

import java.util.List;

public interface IDistributorDtoManager {

    List<DistributorDto> generateDistributorDtos();
    List<DistributorDto> getDistributorDtosByName(String name);
    List<DistributorDto> getAllDistributorDtos();
    List<DistributorDto> getJsonBDistributorDtoTest();
    List<DistributorDto> getJsonBJointureDtoTest();
    List<DistributorDto> getDistributorDtoIfCoinIfDrink(String coinName, int coinAmount, String drinkName, int drinkAmount);

}
