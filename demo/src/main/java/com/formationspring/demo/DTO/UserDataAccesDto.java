package com.formationspring.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.DoubleStream;

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
    public static class Input {
        private Long id;
        private String firstName;
        private String lastName;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Output {
        private Long id;
        private String firstName;
        private String lastName;
    }
}
