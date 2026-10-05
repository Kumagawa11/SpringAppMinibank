package com.example.minibank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="transaction")
@AllArgsConstructor
@NoArgsConstructor
public class TransactionModel {

	public TransactionModel(int accountId, TransactionType type, BigDecimal amount, String description, LocalDateTime createdAt) {
		
		this.accountId = accountId;
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.createdAt = createdAt;
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="account_id")
	private Integer accountId;
	@ManyToOne
	@JoinColumn(name="account_id", insertable = false, updatable = false)
	private AccountModel account;
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	private BigDecimal amount;
	private String description;
	private LocalDateTime createdAt;

	
}
