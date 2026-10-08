package com.example.minibank.app.form;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

//バリデーションを入れる
@Data
@NoArgsConstructor

public class WithdrawalForm {

	@NotNull(message="金額入力は必須です")
	private BigDecimal amount;
	@Size(max=500, message="備考欄は500文字以内で入力してください")
	private String description;
	
}
