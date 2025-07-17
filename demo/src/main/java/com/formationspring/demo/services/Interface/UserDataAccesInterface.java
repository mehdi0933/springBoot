package com.formationspring.demo.services.Interface;
import  com.formationspring.demo.DTO.UserDataAccesDto;
import java.util.List;

public interface UserDataAccesInterface {

    List<UserDataAccesDto.UserOutputDto> getAllUsers();
    List<UserDataAccesDto.UserOutputDto> saveAllUsers(List<UserDataAccesDto.UserInputDto> users);
}
