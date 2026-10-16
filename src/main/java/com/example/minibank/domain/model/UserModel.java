package com.example.minibank.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Table(name = "users")
@NoArgsConstructor
@Data
public class UserModel {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String password;

}
