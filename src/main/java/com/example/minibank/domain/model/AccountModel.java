package com.example.minibank.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.minibank.exception.IllegalAmountException;
import com.example.minibank.exception.InsufficientBalanceException;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "accounts")
@NoArgsConstructor
public class AccountModel {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "user_id")
    private int userId;

    private BigDecimal balance;

    private int accountNumber;

    public void deposit(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) == 0
            || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalAmountException("金額が不正です");
        }

        this.balance = this.balance.add(amount);

    }

    public void withdrawal(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalAmountException("金額が不正です");
        }

        if (amount.compareTo(this.balance) >= 0) {
            throw new InsufficientBalanceException("残高が不足しています");
        } else {
            this.balance = this.balance.subtract(amount);
        }
    }

    public boolean isAccountExist(Integer accountNumber) {

        if (this.accountNumber == (accountNumber)) {
            return true;
        }

        return false;
    }
}