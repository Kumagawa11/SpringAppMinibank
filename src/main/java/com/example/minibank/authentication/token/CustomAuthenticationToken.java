package com.example.minibank.authentication.token;

import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthenticationToken extends AbstractAuthenticationToken {

	private final String username;
	private final String password;
	private final Integer accountNumber;
	
	public CustomAuthenticationToken(
			String username,
			String password,
			Integer accountNumber
			) {
		
		super(Collections.emptyList());
		
		this.username = username;
		this.password = password;
		this.accountNumber = accountNumber;
		
		setAuthenticated(false);
		
	}
	
	public CustomAuthenticationToken(
			String username,
			Collection<? extends GrantedAuthority> authorities,
			Integer accountNumber
			) {
		
		super(authorities);
		
		this.username = username;
		this.accountNumber = accountNumber;
		this.password = null;
		
		setAuthenticated(true);
		
		
	}

	@Override
	public @Nullable Object getCredentials() {
		return this.password;
	}

	@Override
	public @Nullable Object getPrincipal() {
		return this.username;
	}

}
