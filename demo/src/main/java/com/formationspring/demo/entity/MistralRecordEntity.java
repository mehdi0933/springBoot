package com.formationspring.demo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name= "data_ai")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class MistralRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String promptMsg;
    private String url;
    private String apiKey;
    private LocalDateTime searchDateTime;
    private String model;

}

