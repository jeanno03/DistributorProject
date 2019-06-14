package com.distributor.controls.implementations;

import com.distributor.constants.MyConstant;
import com.distributor.controls.interfaces.IMyUserDtoManager;
import com.distributor.controls.motherclasses.MyUserManagerImpl;
import com.distributor.dtos.MyUserDto;
import com.distributor.entities.MyUser;
import com.distributor.models.MyRoleJsonHashSet;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class MyUserDtoManagerImpl extends MyUserManagerImpl implements IMyUserDtoManager {

    @PersistenceContext(unitName = "distributorDB")
    EntityManager em;

    private static List<MyUserDto> myUserDtos;

    public MyUserDtoManagerImpl() {
    }

    private void initMyUserDtos(){
        myUserDtos = new ArrayList<>();
    }

    @Override
    public List<MyUserDto> generateMyUsers(){
        initMyUserDtos();

        List<MyUser> myUsers1 = new ArrayList<>();
        MyUser myUser1;
        MyUser myUser2;
        MyUser myUser3;

        MyRoleJsonHashSet myRoleJsonHashSet1 = new MyRoleJsonHashSet(MyConstant.MY_ROLES_1);
        MyRoleJsonHashSet myRoleJsonHashSet2 = new MyRoleJsonHashSet(MyConstant.MY_ROLES_2);
        MyRoleJsonHashSet myRoleJsonHashSet3 = new MyRoleJsonHashSet(MyConstant.MY_ROLES_3);

        myUsers1.add(myUser1 = new MyUser("Jean01", "12345678", "jean01@jean.fr"));
        myUsers1.add(myUser2 = new MyUser("Jean02", "12345678", "jean02@jean.fr"));
        myUsers1.add(myUser3 = new MyUser("Jean03", "12345678", "jean03@jean.fr"));

        myUser1.setMyRoleJsonHashSet(myRoleJsonHashSet1);
        myUser2.setMyRoleJsonHashSet(myRoleJsonHashSet2);
        myUser3.setMyRoleJsonHashSet(myRoleJsonHashSet3);

        try {

            em.persist(myUser1);
            em.persist(myUser2);
            em.persist(myUser3);

            //retrieve MyUser from DB
            List<MyUser> myUsers2 = new ArrayList<>();
            myUsers2.add(getMyUserNativeQuery("Jean01").get(0));
            myUsers2.add(getMyUserNativeQuery("Jean02").get(0));
            myUsers2.add(getMyUserNativeQuery("Jean03").get(0));

            myUsers2.forEach(m->{
                myUserDtos.add(getMyUserDto(m));
            });

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return myUserDtos;
    }

    @Override
    public List<MyUserDto> getAllMyUserDtos(){
        initMyUserDtos();
            getAllMyUser().forEach(m->{
                myUserDtos.add(getMyUserDto(m));
            });
        return myUserDtos;
    }

    @Override
    public List<MyUserDto>  getMyUserDtoByName(String name){
        initMyUserDtos();
        myUserDtos.add(getMyUserDto(getMyUserNativeQuery(name).get(0)));
        return myUserDtos;
    }

}
