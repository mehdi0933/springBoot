package com.formationspring.demo.services.Interface;
import com.formationspring.demo.dto.dtoentity.UserDataAccesDto;
import java.util.List;

public interface UserDataAccesInterface {

    List<UserDataAccesDto.Output> getAllUsers();
    List<UserDataAccesDto.Output> saveAllUsers(List<UserDataAccesDto.Input> users);
}
