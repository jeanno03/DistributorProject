package com.distributor.controls.motherclasses;

import com.distributor.entities.Drink;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class DrinkManagerImpl {

    @PersistenceContext(unitName = "distributorDB")
    EntityManager em;

    private static List<Drink> drinks;

    public DrinkManagerImpl() {}

    private void initDrinks(){
        drinks= new ArrayList<>();
    }
    public void persistDrink(){

        List<Drink> drinksP = new ArrayList<>();

        Drink drink1;
        Drink drink2;
        Drink drink3;
        Drink drink4;
        Drink drink5;
        Drink drink6;
        Drink drink7;
        Drink drink8;
        Drink drink9;
        Drink drink10;

        drinksP.add(drink1 = new Drink("COC80", "Coca-Cola"));
        drinksP.add(drink2 = new Drink("ORA80", "Orangina"));
        drinksP.add(drink3 = new Drink("OAS80", "Oasis Orange"));
        drinksP.add(drink4 = new Drink("EVI100", "Evian 75cl"));
        drinksP.add(drink5 = new Drink("RED120", "Red-Bull"));
        drinksP.add(drink6 = new Drink("COC90", "Coca-Cola"));
        drinksP.add(drink7 = new Drink("ORA90", "Orangina"));
        drinksP.add(drink8 = new Drink("OAS90", "Oasis Orange"));
        drinksP.add(drink9 = new Drink("EVI120", "Evian 75cl"));
        drinksP.add(drink10 = new Drink("RED200", "Red-Bull"));

        try{
            drinksP.forEach(d-> {
                em.persist(d);
                try {

                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            });
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }


    public List<Drink> getDrinkByCode(String code){
        initDrinks();
        TypedQuery<Drink> qr = em.createNamedQuery("getDrinkByCode",Drink.class);

        try{
            qr.setParameter("paramCode", code);

            drinks.add(qr.getResultList().get(0));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return drinks;
    }


    public List<Drink> getDrinks(){
        initDrinks();
        TypedQuery<Drink> qr = em.createNamedQuery("getAllDrinks",Drink.class);
        try{
            drinks = qr.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return drinks;
    }


}
