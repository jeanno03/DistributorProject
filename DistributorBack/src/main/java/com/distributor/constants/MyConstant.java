package com.distributor.constants;

import com.distributor.enums.Coin;
//import com.distributor.enums.Drink;
import com.distributor.enums.MyRole;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public interface MyConstant {

    static final String DOMAIN = "distributor.com";
    static final String ROLES = "rôles utilisateur";
    static final List<Coin> COINS = getCoins ();
    static final HashSet<MyRole> MY_ROLES_1 = getRoles1();
    static final HashSet<MyRole> MY_ROLES_2 = getRoles2();
    static final HashSet<MyRole> MY_ROLES_3 = getRoles3();

    static List<Coin> getCoins () {
        List<Coin> coins = new ArrayList<>();
        coins.add(Coin.UN_CENTIME);
        coins.add(Coin.DEUX_CENTIMES);
        coins.add(Coin.CINQ_CENTIMES);
        coins.add(Coin.DIX_CENTIMES);
        coins.add(Coin.VINGT_CENTIMES);
        coins.add(Coin.CINQUANTE_CENTIMES);
        coins.add(Coin.UN_EUROS);
        coins.add(Coin.DEUX_EUROS);
        return coins;
    }

    static HashSet<MyRole> getRoles1(){
        HashSet<MyRole> roles = new HashSet<>();
        roles.add(MyRole.VISITOR);
        return roles;
    }

    static HashSet<MyRole> getRoles2(){
        HashSet<MyRole> roles = getRoles1();
        roles.add(MyRole.USER);
        return roles;
    }

    static HashSet<MyRole> getRoles3(){
        HashSet<MyRole> roles = getRoles2();
        roles.add(MyRole.ADMINISTRATOR);
        return roles;
    }

}
