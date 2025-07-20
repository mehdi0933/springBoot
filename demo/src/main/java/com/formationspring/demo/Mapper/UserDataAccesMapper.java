package com.formationspring.demo.Mapper;

import com.formationspring.demo.DTO.UserDataAccesDto;

public class UserDataAccesMapper {

    public static UserDataAccesDto fromInput(UserDataAccesDto.Input input) {
        return UserDataAccesDto.builder()
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .build();
    }

    public static UserDataAccesDto.Output toOutput(UserDataAccesDto userDto) {
        return UserDataAccesDto.Output.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build();
    }
}

