package com.example.minibank.authentication.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.example.minibank.authentication.token.CustomAuthenticationToken;

public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter{


    protected CustomAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
	}

	@Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response)
            throws AuthenticationException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Integer accountNumber = Integer.valueOf(request.getParameter("accountNumber"));

        CustomAuthenticationToken token =
                new CustomAuthenticationToken(username, password, accountNumber);

        return this.getAuthenticationManager().authenticate(token);
    }
	
}
