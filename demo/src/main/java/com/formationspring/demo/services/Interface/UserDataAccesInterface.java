package com.formationspring.demo.services.Interface;
import  com.formationspring.demo.DTO.UserDataAccesDto;
import java.util.List;

public interface UserDataAccesInterface {

    List<UserDataAccesDto.OutputDto> getAllUsers();
    List<UserDataAccesDto.OutputDto> saveAllUsers(List<UserDataAccesDto.InputDto> users);
}
