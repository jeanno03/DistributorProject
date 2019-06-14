package com.distributor.singleton;

import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.lang.JoseException;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MySingleton {

    private List<JsonWebKey> jsonWebKeys;

    public MySingleton() {
        System.out.println("**********************Initialisation du singleton************************");
        generateJsonWebKeys();
    }

        private void generateJsonWebKeys () {
            System.out.println("**********************Initialisation du generateJsonWebKeys************************");
            jsonWebKeys = new ArrayList<>();


            for (int i = 0; i < 3; i++) {
                JsonWebKey jsonWebKey = null;
                try {
                    int kid = i;
                    jsonWebKey = RsaJwkGenerator.generateJwk(2048);
                    jsonWebKey.setKeyId(String.valueOf(kid));
                    jsonWebKeys.add(jsonWebKey);
                    System.out.println("JsonWebKeys number : " + i + " generate");
                } catch (JoseException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

    public List<JsonWebKey> getJsonWebKeys() {
        return this.jsonWebKeys;
    }

}
