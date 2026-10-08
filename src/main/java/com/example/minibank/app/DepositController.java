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
import com.example.minibank.domain.service.deposit.DepositService;
import com.example.minibank.domain.service.user.UserService;
import com.example.minibank.form.DepositForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/deposit")
@RequiredArgsConstructor
public class DepositController {

	private final DepositService depositService;
	private final UserService userService;

	@GetMapping
	public String showDeposit(@ModelAttribute DepositForm depositForm) {

		return "deposit";

	}

	@PostMapping
	public String doDeposit(
			@Valid @ModelAttribute DepositForm depositForm,
			BindingResult result,
			@AuthenticationPrincipal UserDetails userDetails) {

		if (result.hasErrors()) {

			return "/deposit";

		}

		BigDecimal amount = depositForm.getAmount();
		int userId = userService.getUserIdByUsername(userDetails.getUsername());
		depositService.deposit(
				userId, amount, TransactionType.deposit,
				depositForm.getDescription());

		return "redirect:/dashboard";

	}

}
