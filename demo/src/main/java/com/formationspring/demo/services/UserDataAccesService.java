package com.formationspring.demo.services;

import com.formationspring.demo.DAL.UserRepositoryJpa;
import com.formationspring.demo.DTO.UserDataAccesDto;
import com.formationspring.demo.DTO.UserDataAccesDto.Input;
import com.formationspring.demo.DTO.UserDataAccesDto.Output;
import com.formationspring.demo.entity.UsersEntity;
import com.formationspring.demo.mapper.UserDataAccesMapper;
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
    public List<Output> getAllUsers() {
        List<UsersEntity> entities = userRepositoryJpa.findAll();
        List<Output> outputList = new ArrayList<>();

        for (UsersEntity entity : entities) {
            UserDataAccesDto dto = UserDataAccesDto.builder()
                    .id(entity.getId())
                    .firstName(entity.getFirstName())
                    .lastName(entity.getLastName())
                    .build();

            outputList.add(UserDataAccesMapper.toOutput(dto));
        }

        return outputList;
    }

    @Override
    public List<Output> saveAllUsers(List<Input> users) {
        List<UsersEntity> entitiesToSave = new ArrayList<>();

        for (Input inputDto : users) {
            UserDataAccesDto dto = UserDataAccesMapper.fromInput(inputDto);
            UsersEntity entity = new UsersEntity(dto.getId(), dto.getFirstName(), dto.getLastName());
            entitiesToSave.add(entity);
        }

        List<UsersEntity> savedEntities = userRepositoryJpa.saveAll(entitiesToSave);
        List<Output> outputList = new ArrayList<>();

        for (UsersEntity savedEntity : savedEntities) {
            UserDataAccesDto dto = UserDataAccesDto.builder()
                    .id(savedEntity.getId())
                    .firstName(savedEntity.getFirstName())
                    .lastName(savedEntity.getLastName())
                    .build();

            outputList.add(UserDataAccesMapper.toOutput(dto));
        }

        return outputList;
    }
}
