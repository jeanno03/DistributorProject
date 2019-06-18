package com.distributor.controls.implementations;

import com.distributor.controls.interfaces.IDistributorDtoManager;
import com.distributor.controls.interfaces.IDrinkDtoManager;
import com.distributor.controls.converters.DistributorConverter;
import com.distributor.dtos.DistributorDto;
import com.distributor.entities.Distributor;
import com.distributor.entities.DistributorLine;
import com.distributor.enums.Coin;
import com.distributor.models.CoinJsonHashMap;
import com.distributor.models.DrinkJson;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Transactional
public class DistributorDtoManagerImpl extends DistributorConverter implements IDistributorDtoManager {

    @PersistenceContext(unitName = "distributorDB")
    EntityManager em;

    @Inject
    IDrinkDtoManager drinkDtoManager;

    private static List<DistributorDto> distributorDtos;

    public DistributorDtoManagerImpl() {
    }

    private void initDistributorDto(){
        distributorDtos = new ArrayList<>();
    }


    @Override
    public List<DistributorDto> generateDistributorDtos(){
        initDistributorDto();

        drinkDtoManager.persistDrink();

        for(int i=0;i<10;i++){
            String name = "Distributeur" ;
            name += " "+i;
            distributorDtos.add(generateAppDistributorTest1(name));
        }

        for(int i=0;i<10;i++){
            String name = "Distributeur de luxe" ;
            name += " "+i;
            distributorDtos.add(generateAppDistributorTest2(name));
        }
        return distributorDtos;
    }

    @Override
    public List<DistributorDto> getDistributorDtosByName(String name) {
        initDistributorDto();
            getDistributorsByName(name).forEach(d->{
                distributorDtos.add(getDistributorDto(d));
                try {
                    Thread.sleep(10);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            });
        return distributorDtos;
    }

    @Override
    public List <DistributorDto> getAllDistributorDtos(){
        initDistributorDto();
            getAllDistributors().forEach(d->{
                distributorDtos.add(getDistributorDto(d));
                try {
                    Thread.sleep(10);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            });
        return distributorDtos;
    }

    @Override
    public List<DistributorDto> getJsonBDistributorDtoTest() {
        initDistributorDto();
        getJsonBDistributorTest().forEach(d->{
            distributorDtos.add(getDistributorDto(d));
            try {
                Thread.sleep(10);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        });
        return distributorDtos;
    }

    @Override
    public List<DistributorDto> getJsonBJointureDtoTest() {
        initDistributorDto();

        getJsonBJointureTest().forEach(d->{
            distributorDtos.add(getDistributorDto(d));
            try {
                Thread.sleep(10);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        });
        return distributorDtos;
    }

    @Override
    public List<DistributorDto> getDistributorDtoIfCoinIfDrink(String coinName, int coinAmount, String drinkName, int drinkAmount){
        initDistributorDto();
        getDistributorIfCoinIfDrink(coinName, coinAmount, drinkName, drinkAmount).forEach(d->{
            distributorDtos.add(getDistributorDto(d));
            try {
                Thread.sleep(10);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        });
        return distributorDtos;
    }

    private DistributorDto getLastDistributorDto(){
        return getDistributorDto(getLastDistributor().get(0));
    }

    private DistributorDto generateAppDistributorTest1(String name) {
        Distributor distributor1 = new Distributor(name);

        HashMap<Coin,Integer> coinIntegerHashMap = new HashMap<>();
        coinIntegerHashMap.put(Coin.UN_CENTIME,77);
        coinIntegerHashMap.put(Coin.DEUX_CENTIMES,50);
        coinIntegerHashMap.put(Coin.CINQ_CENTIMES,50);
        coinIntegerHashMap.put(Coin.DIX_CENTIMES,55);
        coinIntegerHashMap.put(Coin.VINGT_CENTIMES,50);
        coinIntegerHashMap.put(Coin.CINQUANTE_CENTIMES,50);
        coinIntegerHashMap.put(Coin.UN_EUROS,20);
        coinIntegerHashMap.put(Coin.DEUX_EUROS,20);

        CoinJsonHashMap coinJsonHashMap = new CoinJsonHashMap();
        coinJsonHashMap.setCoinIntegerHashMap(coinIntegerHashMap);
        distributor1.setCoinJsonHashMap(coinJsonHashMap);

        DrinkJson drinkJson1 = new DrinkJson(drinkDtoManager.getDrinkByCode("COC80").get(0),0.8f);
        DrinkJson drinkJson2 = new DrinkJson(drinkDtoManager.getDrinkByCode("ORA80").get(0),0.8f);
        DrinkJson drinkJson3 = new DrinkJson(drinkDtoManager.getDrinkByCode("OAS80").get(0),0.8f);
        DrinkJson drinkJson4 = new DrinkJson(drinkDtoManager.getDrinkByCode("EVI100").get(0),1f);
        DrinkJson drinkJson5 = new DrinkJson(drinkDtoManager.getDrinkByCode("RED120").get(0),1.2f);

        List<DistributorLine> distributorLines1 = new ArrayList<>();

        DistributorLine distributorLine1;
        DistributorLine distributorLine2;
        DistributorLine distributorLine3;
        DistributorLine distributorLine4;
        DistributorLine distributorLine5;

        distributorLines1.add(distributorLine1 = new DistributorLine(10, drinkJson1, distributor1));
        distributorLines1.add(distributorLine2 = new DistributorLine(20, drinkJson2, distributor1));
        distributorLines1.add(distributorLine3 = new DistributorLine(30, drinkJson3, distributor1));
        distributorLines1.add(distributorLine4 = new DistributorLine(40, drinkJson4, distributor1));
        distributorLines1.add(distributorLine5 = new DistributorLine(50, drinkJson5, distributor1));

        distributor1.setDistributorLines(distributorLines1);

        em.persist(distributor1);

        distributorLines1.forEach(d
            ->{
            try {
            em.persist(d);
            Thread.sleep(10);

            }catch(Exception ex){
                ex.printStackTrace();
            }
         }
        );

        DistributorDto distributorDto = getLastDistributorDto();
        return distributorDto;
    }

    private DistributorDto generateAppDistributorTest2(String name) {
        System.out.println("Methode : generateAppDistributorTest2");
        System.out.println("name : " + name);
        Distributor distributor2 = new Distributor(name);

        HashMap<Coin,Integer> coinIntegerHashMap = new HashMap<>();
        coinIntegerHashMap.put(Coin.UN_CENTIME,50);
        coinIntegerHashMap.put(Coin.DEUX_CENTIMES,99);
        coinIntegerHashMap.put(Coin.CINQ_CENTIMES,40);
        coinIntegerHashMap.put(Coin.DIX_CENTIMES,28);
        coinIntegerHashMap.put(Coin.VINGT_CENTIMES,100);
        coinIntegerHashMap.put(Coin.CINQUANTE_CENTIMES,45);
        coinIntegerHashMap.put(Coin.UN_EUROS,99);
        coinIntegerHashMap.put(Coin.DEUX_EUROS,109);

        CoinJsonHashMap coinJsonHashMap = new CoinJsonHashMap();
        coinJsonHashMap.setCoinIntegerHashMap(coinIntegerHashMap);
        distributor2.setCoinJsonHashMap(coinJsonHashMap);

        DrinkJson drinkJson1 = new DrinkJson(drinkDtoManager.getDrinkByCode("COC90").get(0),0.9f);
        DrinkJson drinkJson2 = new DrinkJson(drinkDtoManager.getDrinkByCode("ORA90").get(0),0.9f);
        DrinkJson drinkJson3 = new DrinkJson(drinkDtoManager.getDrinkByCode("OAS90").get(0),0.9f);
        DrinkJson drinkJson4 = new DrinkJson(drinkDtoManager.getDrinkByCode("EVI120").get(0),1.2f);
        DrinkJson drinkJson5 = new DrinkJson(drinkDtoManager.getDrinkByCode("RED200").get(0),2f);

        DistributorLine distributorLine1 = new DistributorLine(20, drinkJson1, distributor2);
        DistributorLine distributorLine2 = new DistributorLine(30, drinkJson2, distributor2);
        DistributorLine distributorLine3 = new DistributorLine(40, drinkJson3, distributor2);
        DistributorLine distributorLine4 = new DistributorLine(50, drinkJson4, distributor2);
        DistributorLine distributorLine5 = new DistributorLine(100, drinkJson5, distributor2);

        List<DistributorLine> distributorLines = new ArrayList<>();

        distributorLines.add(distributorLine1);
        distributorLines.add(distributorLine2);
        distributorLines.add(distributorLine3);
        distributorLines.add(distributorLine4);
        distributorLines.add(distributorLine5);

        distributor2.setDistributorLines(distributorLines);

        em.persist(distributor2);

        distributorLines.forEach(d
                        ->{
                    try {
                        em.persist(d);
                        Thread.sleep(15);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
        );

        DistributorDto distributorDto = getLastDistributorDto();
        return distributorDto;
    }

    @Override
    public List<DistributorDto> saveDistributor(Distributor distributor, HashMap<Coin, Integer> coinIntegerHashMap){
        initDistributorDto();
        em.persist(distributor);
        distributorDtos.add(getLastDistributorDto());
        return distributorDtos;
    }

}

