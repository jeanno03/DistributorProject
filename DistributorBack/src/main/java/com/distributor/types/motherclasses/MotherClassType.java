package com.distributor.types.motherclasses;

import com.distributor.constants.MyConstant;
import com.distributor.entities.Drink;
import com.distributor.enums.Coin;
import com.distributor.models.DrinkJson;
import com.distributor.tools.MathsTool;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

//https://www.baeldung.com/hibernate-custom-types
public abstract class MotherClassType implements UserType , MathsTool {

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.JAVA_OBJECT};
    }

    @Override
    public boolean equals(Object obj1, Object obj2) throws HibernateException {
        if (obj1 == null) {
            return obj2 == null;
        }
        return obj1.equals(obj2);
    }

    @Override
    public int hashCode(Object obj) throws HibernateException {
        return obj.hashCode();
    }

    //cette méthode va convertir l'object en string avant persistence
    //attention dans le cas des enum c'est l'object qui va etre persisté et pas sa valeure
    @Override
    public void nullSafeSet(PreparedStatement ps, Object value, int idx, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
        if (value == null) {
            ps.setNull(idx, Types.OTHER);
            return;
        }
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final StringWriter w = new StringWriter();
            mapper.writeValue(w, value);
            w.flush();
            ps.setObject(idx, w.toString(), Types.OTHER);
        } catch (final Exception ex) {
            throw new RuntimeException("Failed to convert Invoice to String: " + ex.getMessage(), ex);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        try {
            // use serialization to create a deep copy
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(value);
            oos.flush();
            oos.close();
            bos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(bos.toByteArray());
            return new ObjectInputStream(bais).readObject();
        } catch (ClassNotFoundException | IOException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) this.deepCopy(value);
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return this.deepCopy(cached);
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return this.deepCopy(original);
    }

    //a mettre dans class mere une fois que enum generic OK
    public Object generateObjectFromEnumList(Object object1, JsonNode node, Class aClass){

        if(aClass.equals(Coin.class)){

            HashMap<Coin,Integer> object2 = (HashMap<Coin,Integer>) object1;
            try{
                MyConstant.COINS.forEach(c->{
                    JsonNode coinIntegerHashMapNode = node.path("coinIntegerHashMap").path(c.toString());
                    int value = Integer.valueOf(coinIntegerHashMapNode.asText());
                    object2.put(c, value);

                });

                return object2;

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return null;
        }

                if(aClass.equals(Drink.class)){

            DrinkJson object2 = (DrinkJson) object1;

          try{
              object2.setPrice(getFloatWithTwoDecimal(Float.valueOf(node.path("price").asText())));
              Drink drink = new Drink(Long.valueOf(node.path("drink").path("id").asText()), node.path("drink").path("code").asText(),node.path("drink").path("name").asText());
              object2.setDrink(drink);
          }catch(Exception ex){
              ex.printStackTrace();
          }
            return object2;
        }
        return null;

    }

}
