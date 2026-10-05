package com.example.minibank.app;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.minibank.domain.service.AccountService;
import com.example.minibank.domain.service.HistoryService;
import com.example.minibank.domain.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/history")
public class HistoryController {
	
	private final HistoryService historyService;
	private final AccountService accountService;
	private final UserService userService;

	@GetMapping
	public String showHistory(Model model, 
			@AuthenticationPrincipal UserDetails userDetails) {
		
		
		Integer userId = userService.getUserIdByUsername(userDetails.getUsername());
		Integer accountId = accountService.getAccountByUserId(userId).get().getId();

		model.addAttribute("history", historyService.getHistoryByAccountId(accountId));
		return "history";
		
	}
	
	
}
