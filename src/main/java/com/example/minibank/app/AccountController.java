package com.example.minibank.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.minibank.app.form.LoginForm;

@Controller
@RequestMapping("/account")
public class AccountController {

	@GetMapping
	public String login(@ModelAttribute LoginForm loginForm) {
		
		
		return "login";
		
	}
	
}
