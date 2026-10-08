package com.example.minibank.authentication.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.minibank.domain.infrastructure.UserRepository;
import com.example.minibank.domain.model.UserModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		UserModel user = Optional.ofNullable(userRepository.findUserByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("user not found"));
		
		return User
				.withUsername(user.getUsername())
				.password("{noop}" + user.getPassword())
				.build();
		
	}
	
}
