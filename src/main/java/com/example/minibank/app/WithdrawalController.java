package com.example.minibank.app;

import jakarta.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.minibank.app.form.WithdrawalForm;
import com.example.minibank.domain.model.TransactionType;
import com.example.minibank.domain.service.user.UserService;
import com.example.minibank.domain.service.withdrawal.WithdrawalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/withdrawal")
public class WithdrawalController {

	private final WithdrawalService withdrawalService;
	private final UserService userService;
	
	@GetMapping
	public String login(@ModelAttribute WithdrawalForm withdrawalForm) {
		return "withdrawal";
	}
	
	@PostMapping
	public String doWithdrawal(
			@Valid @ModelAttribute WithdrawalForm withdrawalForm,
			BindingResult result,
			@AuthenticationPrincipal UserDetails userDetails,
			RedirectAttributes attributes
			
			) {
		
		if(result.hasErrors()) {
			return "/withdrawal";
		}

		withdrawalService.withdrawal(
				userService.getUserIdByUsername(userDetails.getUsername()),
				withdrawalForm.getAmount(),
				TransactionType.withdraw,
				withdrawalForm.getDescription()
				);
		
		attributes.addFlashAttribute("withdrawalSuccess","出金に成功しました");
		return "redirect:/dashboard"; 
		
	}
	
}
