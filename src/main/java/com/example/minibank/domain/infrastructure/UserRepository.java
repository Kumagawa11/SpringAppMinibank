package com.example.minibank.domain.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minibank.domain.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{

	UserModel findUserByUsername(String username);

}
