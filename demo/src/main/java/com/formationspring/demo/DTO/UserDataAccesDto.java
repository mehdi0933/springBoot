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
    public static class InputDto {
        private Long id;
        private String firstName;
        private String lastName;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class OutputDto {
        private Long id;
        private String firstName;
        private String lastName;
    }

    public static UserDataAccesDto fromInput(InputDto inputDto) {
        return UserDataAccesDto.builder()
                .id(inputDto.getId())
                .firstName(inputDto.getFirstName())
                .lastName(inputDto.getLastName())
                .build();
    }

    public static OutputDto toOutput(UserDataAccesDto userDto) {
        return OutputDto.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build();
    }
}
