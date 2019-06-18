package com.distributor.controls.interfaces;

import com.distributor.dtos.DistributorDto;
import com.distributor.entities.Distributor;
import com.distributor.enums.Coin;

import java.util.HashMap;
import java.util.List;

public interface IDistributorDtoManager {

    List<DistributorDto> generateDistributorDtos();
    List<DistributorDto> getDistributorDtosByName(String name);
    List<DistributorDto> getAllDistributorDtos();
    List<DistributorDto> getJsonBDistributorDtoTest();
    List<DistributorDto> getJsonBJointureDtoTest();
    List<DistributorDto> getDistributorDtoIfCoinIfDrink(String coinName, int coinAmount, String drinkName, int drinkAmount);
    List<DistributorDto> saveDistributor(Distributor distributor, HashMap<Coin, Integer> coinIntegerHashMap);

}
