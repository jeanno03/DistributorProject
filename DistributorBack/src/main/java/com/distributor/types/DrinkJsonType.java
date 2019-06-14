package com.distributor.types;

import com.distributor.entities.Drink;
import com.distributor.models.DrinkJson;
import com.distributor.tools.MathsTool;
import com.distributor.types.motherclasses.MotherClassType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DrinkJsonType extends MotherClassType implements MathsTool {

    private static DrinkJson drinkJson;

    public DrinkJsonType() {
    }

    @Override
    public Class returnedClass() {
        return DrinkJson.class;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        drinkJson = new DrinkJson();

        if (rs.wasNull()) {
            return null;
        }else{
            String nodeString = rs.getString(names[0]);
            ObjectMapper mapper = new ObjectMapper();

            try{
                JsonNode node = mapper.readTree(nodeString);

                drinkJson = (DrinkJson) generateObjectFromEnumList(this.drinkJson,node, Drink.class);

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        return drinkJson;
    }


}
