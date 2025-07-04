package com.formationspring.demo.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "ApiEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ApiEntity {
    @Id
    private int userId;
    private int id;
    private String title;
    private String body;

}
