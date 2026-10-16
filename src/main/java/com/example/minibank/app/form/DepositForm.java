package com.example.minibank.app.form;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepositForm {

	@NotNull(message="入金額の入力は必須です")
	@DecimalMin(value = "0", message = "0以上の数値を入力してください")
	@DecimalMax(value = "999999999", message = "10桁以内で入力してください")
	private BigDecimal amount;
	@Size(max=500, message="備考欄は500文字以内で入力してください")
	private String description;
	
}
