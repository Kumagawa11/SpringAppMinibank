package com.example.minibank.app.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginForm {

	private String username;
	private String password;
	private Integer accountNumber;
	
}
