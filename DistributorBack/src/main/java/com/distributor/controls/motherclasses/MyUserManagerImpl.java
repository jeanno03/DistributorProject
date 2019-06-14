package com.distributor.controls.motherclasses;

import com.distributor.controls.converters.MyUserConverter;
import com.distributor.entities.MyUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class MyUserManagerImpl extends MyUserConverter {

    @PersistenceContext(unitName = "distributorDB")
    EntityManager em;

    private static List<MyUser> myUsers;

    public MyUserManagerImpl() {

    }

    private void initMyUsers(){
        myUsers = new ArrayList<>();
    }

    public List<MyUser> getAllMyUser(){
        initMyUsers();
        TypedQuery<MyUser> qr = em.createNamedQuery("getAllMyUsers",MyUser.class);
        try{
            myUsers = qr.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return myUsers;
    }

    public List<MyUser> getMyUserNativeQuery(String name) {
        initMyUsers();
        myUsers.add(em.createNamedQuery("native.query.getMyUserByLogin", MyUser.class)
                .setParameter("paramLogin",name)
                .getSingleResult());
        return myUsers;
    }

    public List<MyUser> getMyUserByLogin(String login){
        initMyUsers();
        TypedQuery<MyUser> qr = em.createNamedQuery("getMyUserByLogin",MyUser.class);
        qr.setParameter("paramLogin", login);
        try{
            myUsers.add(qr.getSingleResult());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return myUsers;
    }
}
