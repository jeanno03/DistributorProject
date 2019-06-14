package com.distributor.controls.converters;

import com.distributor.dtos.MyUserDto;
import com.distributor.entities.MyUser;

public class MyUserConverter {

    private MyUserDto myUserDto;

    public MyUserConverter() {
    }

    public MyUserDto getMyUserDto(MyUser myUser){
        myUserDto = new MyUserDto();
        try {
            myUserDto.setId(myUser.getId());
            myUserDto.setLogin(myUser.getLogin());
            myUserDto.setEmail(myUser.getEmail());
            myUserDto.setMyRoleJsonHashSet(myUser.getMyRoleJsonHashSet());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return myUserDto;
    }
}
