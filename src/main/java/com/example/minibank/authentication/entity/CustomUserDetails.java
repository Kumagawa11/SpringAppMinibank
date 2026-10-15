package com.example.minibank.authentication.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.minibank.domain.model.AccountModel;



public class CustomUserDetails extends User {

	private Integer loginUserId;
	private List<AccountModel> accounts;

	
	public CustomUserDetails(
			Integer id,
			String username,
			String password,
			Collection<? extends GrantedAuthority> authorities,
			List<AccountModel> accounts
			) {
		
		super(username, password, authorities);
		
		this.loginUserId = id;
		this.accounts = accounts;
		
		
	}
	
	public Integer getLoginUserId() {
		
		return this.loginUserId;
		
	}
	
	public List<AccountModel> getAccounts() {
		
		return this.accounts;
		
	}
	
	
}
