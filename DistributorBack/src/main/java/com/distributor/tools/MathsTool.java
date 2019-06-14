package com.distributor.tools;

import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public interface MathsTool {

     public default float getFloatWithTwoDecimal(float entry){
         BigDecimal bd = new BigDecimal(entry).setScale(2, RoundingMode.HALF_UP);
         float result = (float) bd.doubleValue();
         return result;
     }

    public default int generateRandmoKid() {
        Random rand = new Random();
        int randomKid = rand.nextInt(2);
        return randomKid;
    }

    //return password hashé
    public default String getStringSha3(String str){
        try{
            SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
            byte[] digest = digestSHA3.digest(str.getBytes());
            return Hex.toHexString(digest);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

}
