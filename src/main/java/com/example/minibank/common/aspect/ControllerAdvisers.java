package com.example.minibank.common.aspect;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.minibank.domain.model.TransactionType;
import com.example.minibank.exception.AccountNotFoundException;
import com.example.minibank.exception.IllegalAmountException;
import com.example.minibank.exception.InsufficientBalanceException;
import com.example.minibank.exception.SameAccountTransferException;

@ControllerAdvice
public class ControllerAdvisers {

	@ExceptionHandler({ AccountNotFoundException.class })
	public String accountNotFoundError(AccountNotFoundException e, RedirectAttributes attribute) {

		String errorMsg = e.getMessage();

		attribute.addFlashAttribute("errorMsg", errorMsg);

		if (errorMsg.contains(TransactionType.transfer.toString())) {

		attribute.addFlashAttribute("errorMsg", 
				errorMsg.replace(TransactionType.transfer.toString(), ""));
			return "redirect:/transfer";

		} else if (e.getMessage().contains("LOGIN")) {

			return "redirect:/login";

		}

		return "dashboard";

	}

	@ExceptionHandler({ IllegalAmountException.class })
	public String illegalAmountError(IllegalAmountException e, Model model) {

		model.addAttribute("errorMsg", e.getMessage());
		return "deposit";

	}

	@ExceptionHandler({ InsufficientBalanceException.class })
	public String insufficientBalanceError(InsufficientBalanceException e, RedirectAttributes attributes) {

		attributes.addFlashAttribute("errorMsg", e.getMessage());
		return "redirect:/withdrawal";

	}

	@ExceptionHandler({ SameAccountTransferException.class })
	public String sameAccountTransferError(
			SameAccountTransferException e,
			RedirectAttributes attributes) {

		attributes.addFlashAttribute("errorMsg", e.getMessage());
		return "redirect:/transfer";

	}

}
