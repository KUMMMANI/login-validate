package com.me.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class SecureController {

	@RequestMapping("/user/users")
	public String loginSuccess() {
		return "Login Successful!";
	}
}
