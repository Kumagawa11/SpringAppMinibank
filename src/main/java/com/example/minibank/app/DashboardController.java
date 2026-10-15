package com.example.minibank.app;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.minibank.app.form.LoginForm;
import com.example.minibank.authentication.entity.CustomUserDetails;
import com.example.minibank.domain.service.account.AccountService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dashboard")

public class DashboardController {

	private final AccountService accountService;

	@GetMapping
	public String showDashboard(
			@ModelAttribute LoginForm loginForm, 
			Model model,
			@AuthenticationPrincipal CustomUserDetails userDetails
			) {


		int userId = userDetails.getLoginUserId();
		model.addAttribute("balance", accountService.getBalanceByUserId(userId));
		model.addAttribute("username", userDetails.getUsername());

		return "dashboard";

	}

}
