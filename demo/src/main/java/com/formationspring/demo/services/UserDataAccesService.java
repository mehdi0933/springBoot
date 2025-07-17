package com.formationspring.demo.services;

import com.formationspring.demo.DAL.UserRepositoryJpa;
import com.formationspring.demo.DTO.UserDataAccesDto;
import com.formationspring.demo.DTO.UserDataAccesDto.UserInputDto;
import com.formationspring.demo.DTO.UserDataAccesDto.UserOutputDto;
import com.formationspring.demo.entity.UserDataAccesEntity;
import com.formationspring.demo.services.Interface.UserDataAccesInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataAccesService implements UserDataAccesInterface {

    private final UserRepositoryJpa userRepositoryJpa;

    public UserDataAccesService(UserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    @Override
    public List<UserOutputDto> getAllUsers() {
        List<UserDataAccesEntity> entities = userRepositoryJpa.findAll();
        List<UserOutputDto> outputList = new ArrayList<>();

        for (UserDataAccesEntity entity : entities) {
            UserDataAccesDto dto = UserDataAccesDto.builder()
                    .id(entity.getId())
                    .firstName(entity.getFirstName())
                    .lastName(entity.getLastName())
                    .build();

            outputList.add(UserDataAccesDto.toOutput(dto));
        }

        return outputList;
    }

    @Override
    public List<UserOutputDto> saveAllUsers(List<UserInputDto> users) {
        List<UserDataAccesEntity> entitiesToSave = new ArrayList<>();

        for (UserInputDto inputDto : users) {
            UserDataAccesDto dto = UserDataAccesDto.fromInput(inputDto);
            UserDataAccesEntity entity = new UserDataAccesEntity(dto.getId(), dto.getFirstName(), dto.getLastName());
            entitiesToSave.add(entity);
        }

        List<UserDataAccesEntity> savedEntities = userRepositoryJpa.saveAll(entitiesToSave);
        List<UserOutputDto> outputList = new ArrayList<>();

        for (UserDataAccesEntity savedEntity : savedEntities) {
            UserDataAccesDto dto = UserDataAccesDto.builder()
                    .id(savedEntity.getId())
                    .firstName(savedEntity.getFirstName())
                    .lastName(savedEntity.getLastName())
                    .build();

            outputList.add(UserDataAccesDto.toOutput(dto));
        }

        return outputList;
    }
}







