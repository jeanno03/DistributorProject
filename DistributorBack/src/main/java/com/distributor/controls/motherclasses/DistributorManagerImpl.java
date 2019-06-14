package com.distributor.controls.motherclasses;

import com.distributor.entities.Distributor;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class DistributorManagerImpl {

    @PersistenceContext(unitName = "distributorDB")
    EntityManager em;

    private static List<Distributor> distributors;

    public DistributorManagerImpl() {}

    private void initDistributors(){
        distributors = new ArrayList<>();
    }

    public List<Distributor> getLastDistributor(){
        initDistributors();
        TypedQuery<Distributor> qr = em.createNamedQuery("getAllDistributorsDesc",Distributor.class);
        qr.setMaxResults(1);
        try{
            distributors.add(qr.getSingleResult());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return distributors;
    }

    public List<Distributor> getDistributorsByName(String name) {
        initDistributors();
        TypedQuery<Distributor> qr = em.createNamedQuery("getDistributorByName",Distributor.class);
        qr.setParameter("paramName", name);
        try{
            distributors = qr.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return distributors;
    }

    public List <Distributor> getAllDistributors(){
        initDistributors();
        TypedQuery<Distributor> qr = em.createNamedQuery("getAllDistributors",Distributor.class);
        try{
            distributors = qr.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return distributors;
    }

    public List<Distributor> getJsonBDistributorTest() {
        initDistributors();
        try {
            distributors = em.createNamedQuery("native.query.selectJsonBDistributorTest", Distributor.class).getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return distributors;
    }

    public List<Distributor> getJsonBJointureTest() {
        initDistributors();
        try {
            distributors = em.createNamedQuery("native.query.selectJsonBJointureTest", Distributor.class).getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return distributors;
    }

    public List<Distributor> getDistributorIfCoinIfDrink(String coinName, int coinAmount, String drinkName, int drinkAmount) {
        initDistributors();
        try {
            distributors = em.createNamedQuery("native.query.selectDistributorIfCoinIfDrink", Distributor.class)
                    .setParameter("paramCoinName",coinName)
                    .setParameter("paramCoinAmount",coinAmount)
                    .setParameter("paramDrinkName",drinkName)
                    .setParameter("paramDrinkAmount",drinkAmount)
                    .getResultList();

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return distributors;
    }

}
