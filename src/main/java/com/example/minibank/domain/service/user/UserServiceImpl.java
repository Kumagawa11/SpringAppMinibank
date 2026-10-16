package com.example.minibank.domain.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.minibank.domain.infrastructure.UserRepository;
import com.example.minibank.domain.model.UserModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    @Override
    public int getUserIdByUsername(String username) {
        UserModel user = userRepository.findUserByUsername(username);
        int userId = user.getId();
        return userId;
    }

}
