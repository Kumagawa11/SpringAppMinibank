package com.example.minibank.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.minibank.form.LoginForm;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public String showLogin(@ModelAttribute LoginForm loginForm,
			@RequestParam(required = false) String error,
			Model model) {

		if (error != null) {

			model.addAttribute("errorMsg", "ログインに失敗しました");
			return "login";
		}

		return "login";

	}

	@PostMapping
	public String login() {

		return "redirect : /dashboard";

	}

}
