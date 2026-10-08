package com.example.minibank.domain.service.user;

import java.util.List;

import com.example.minibank.domain.model.UserModel;

public interface UserService {

	public List<UserModel> getAll();

	public UserModel getUserModelById(int userId);
	
	public int getUserIdByUsername(String username);

}
