package com.distributor.controls.interfaces;

import com.distributor.dtos.MyUserDto;
import java.util.List;

public interface IMyUserDtoManager {

    List<MyUserDto> generateMyUsers();
    List<MyUserDto> getAllMyUserDtos();
    List<MyUserDto> getMyUserDtoByName(String name);
}
