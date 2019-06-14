package com.distributor.models;

import com.distributor.enums.Coin;
import com.distributor.tools.MathsTool;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class CoinJsonHashMap implements Serializable, MathsTool {

    private HashMap<Coin,Integer> coinIntegerHashMap;
    private float amount;

    public CoinJsonHashMap() {
    }

    public CoinJsonHashMap(HashMap<Coin, Integer> coinIntegerHashMap) {
        this();
        this.coinIntegerHashMap = coinIntegerHashMap;
        this.amount = getFloatWithTwoDecimal(getAmount(coinIntegerHashMap));
    }

    public HashMap<Coin, Integer> getCoinIntegerHashMap() {
        return coinIntegerHashMap;
    }

    public void setCoinIntegerHashMap(HashMap<Coin, Integer> coinIntegerHashMap) {
        this.coinIntegerHashMap = coinIntegerHashMap;
        this.amount = getFloatWithTwoDecimal(getAmount(coinIntegerHashMap));
    }

    private float getAmount(HashMap<Coin, Integer> coinIntegerHashMap) {
        try {
            double amount = coinIntegerHashMap.entrySet().stream().mapToDouble(c -> (getFloatWithTwoDecimal(c.getKey().getValue()) * (float) c.getValue())).sum();
            return (float) amount;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0f;
    }

    public float getAmount() {
        return amount;
    }

}
