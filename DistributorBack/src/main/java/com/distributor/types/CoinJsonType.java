package com.distributor.types;

import com.distributor.enums.Coin;
import com.distributor.models.CoinJsonHashMap;
import com.distributor.tools.MathsTool;
import com.distributor.types.motherclasses.MotherClassType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;

public class CoinJsonType extends MotherClassType implements MathsTool{

    private static HashMap<Coin,Integer> coinIntegerHashMap;

    public CoinJsonType() {

    }

    @Override
    public Class returnedClass() {
        return CoinJsonHashMap.class;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        coinIntegerHashMap = new HashMap<>();
        CoinJsonHashMap coinJsonHashMap = new CoinJsonHashMap();

        float amount = 0f;

        if (rs.wasNull()) {
            return null;
        } else {

            String nodeString = rs.getString(names[0]);

            ObjectMapper mapper = new ObjectMapper();
            try {
                JsonNode node = mapper.readTree(nodeString);

                //non utilisé
                JsonNode amountNode = node.path("amount");
                amount = getFloatWithTwoDecimal(Float.valueOf(amountNode.asText()));

                coinIntegerHashMap = (HashMap<Coin, Integer>) generateObjectFromEnumList(this.coinIntegerHashMap, node, Coin.class);

                coinJsonHashMap.setCoinIntegerHashMap(coinIntegerHashMap);
                return coinJsonHashMap;

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return null;
    }



}
