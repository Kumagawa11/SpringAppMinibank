package com.example.minibank.app;

import java.math.BigDecimal;

import jakarta.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.minibank.domain.model.TransactionType;
import com.example.minibank.domain.service.transfer.TransferService;
import com.example.minibank.domain.service.user.UserService;
import com.example.minibank.form.TransferForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/transfer")
public class TransferController {
	
	private final UserService userService;
	private final TransferService transferService;

	@GetMapping
	public String showTransfer(
			@ModelAttribute TransferForm transferForm) {
		
		
		return "transfer";
		
	}
	
	@PostMapping
	public String doTransfer(
			@Valid @ModelAttribute TransferForm transferForm, 
			BindingResult result,
			@AuthenticationPrincipal UserDetails userDetails) {
		
		
		if(result.hasErrors()) {
			
			return "/transfer";
			
		}
		
		BigDecimal amount = transferForm.getAmount();
		int userId = 
				userService
				.getUserIdByUsername(userDetails.getUsername());

		transferService.transfer(
				userId,
				transferForm.getToAccount(),
				amount,
				TransactionType.transfer,
				transferForm.getDescription()
				);

		
		return "redirect:/dashboard";
		
	}
	
}
