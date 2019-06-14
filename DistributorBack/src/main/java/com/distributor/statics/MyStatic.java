package com.distributor.statics;

import org.jose4j.jwk.JsonWebKey;
import com.distributor.singleton.*;

import javax.inject.Inject;

import java.util.List;

public class MyStatic {

@Inject
MySingleton mySingleton;

    public MyStatic() {
    }

    public List<JsonWebKey> getJsonWebKeys() {
        return mySingleton.getJsonWebKeys();
    }

}
