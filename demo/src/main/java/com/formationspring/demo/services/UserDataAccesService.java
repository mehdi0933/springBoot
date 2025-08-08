package com.formationspring.demo.services;

import com.formationspring.demo.dal.UserRepositoryJpa;
import com.formationspring.demo.dto.dtoentity.UserDataAccesDto;
import com.formationspring.demo.dto.dtoentity.UserDataAccesDto.Input;
import com.formationspring.demo.dto.dtoentity.UserDataAccesDto.Output;
import com.formationspring.demo.entity.UserDataAccesEntity;
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
        List<UserDataAccesEntity> entities = userRepositoryJpa.findAll();
        List<Output> outputList = new ArrayList<>();

        for (UserDataAccesEntity entity : entities) {
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
        List<UserDataAccesEntity> entitiesToSave = new ArrayList<>();

        for (Input inputDto : users) {
            UserDataAccesDto dto = UserDataAccesMapper.fromInput(inputDto);
            UserDataAccesEntity entity = new UserDataAccesEntity(dto.getId(), dto.getFirstName(), dto.getLastName());
            entitiesToSave.add(entity);
        }

        List<UserDataAccesEntity> savedEntities = userRepositoryJpa.saveAll(entitiesToSave);
        List<Output> outputList = new ArrayList<>();

        for (UserDataAccesEntity savedEntity : savedEntities) {
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
