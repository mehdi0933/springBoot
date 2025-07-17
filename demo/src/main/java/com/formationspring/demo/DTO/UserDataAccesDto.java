package com.formationspring.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDataAccesDto {
    private Long id;
    private String firstName;
    private String lastName;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserInputDto {
        private Long id;
        private String firstName;
        private String lastName;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserOutputDto {
        private Long id;
        private String firstName;
        private String lastName;
    }

    public static UserDataAccesDto fromInput(UserInputDto inputDto) {
        return UserDataAccesDto.builder()
                .id(inputDto.getId())
                .firstName(inputDto.getFirstName())
                .lastName(inputDto.getLastName())
                .build();
    }

    public static UserOutputDto toOutput(UserDataAccesDto userDto) {
        return UserOutputDto.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build();
    }
}
