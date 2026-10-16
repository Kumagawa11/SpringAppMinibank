package com.example.minibank.app;

import java.math.BigDecimal;

import jakarta.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.minibank.app.form.DepositForm;
import com.example.minibank.authentication.entity.CustomUserDetails;
import com.example.minibank.domain.model.TransactionType;
import com.example.minibank.domain.service.deposit.DepositService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/deposit")
@RequiredArgsConstructor
public class DepositController {

    private final DepositService depositService;

    @GetMapping
    public String showDeposit(@ModelAttribute DepositForm depositForm) {

        return "deposit";

    }

    @PostMapping
    public String doDeposit(
        @Valid @ModelAttribute DepositForm depositForm,
        BindingResult result,
        @AuthenticationPrincipal CustomUserDetails userDetails) {

        if (result.hasErrors()) {
            return "/deposit";
        }

        BigDecimal amount = depositForm.getAmount();
        int userId = userDetails.getLoginUserId();
        depositService.deposit(
            userId, amount, TransactionType.deposit,
            depositForm.getDescription());

        return "redirect:/dashboard";

    }
}
