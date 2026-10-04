package com.example.minibank.form;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

//バリデーションを入れる
@Data
@NoArgsConstructor
public class TransferForm {

	@NotNull(message="送金先口座番号の指定は必須です")
	private Integer toAccount;
	@NotNull(message="送金金額の入力は必須です")
	private BigDecimal amount;
	@Size(max=500, message="備考欄は500文字以内で入力してください")
	private String description;
	
}
