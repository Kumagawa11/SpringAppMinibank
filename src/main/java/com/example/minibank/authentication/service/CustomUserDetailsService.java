package com.example.minibank.authentication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.minibank.authentication.entity.CustomUserDetails;
import com.example.minibank.domain.infrastructure.AccountRepository;
import com.example.minibank.domain.infrastructure.UserRepository;
import com.example.minibank.domain.model.AccountModel;
import com.example.minibank.domain.model.UserModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	private final AccountRepository accountRepository;

	
	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		UserModel user = Optional.ofNullable(userRepository.findUserByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("user not found"));
		
		System.out.println(user);
		
		List<AccountModel> account =
				accountRepository.getAccountListByUserId(user.getId());
		
		return new CustomUserDetails(
				
				user.getId(),
				user.getUsername(),
				user.getPassword(),
				List.of(),
				account
				
				);
				
		
	}
	
}
