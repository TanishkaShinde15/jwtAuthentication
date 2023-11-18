package com.jwt.jwtAuthentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
	
	@GetMapping("welcome")
	public String welcome() {
		
		String str= "accessible only for authorized users";
		
		return str;
		
	}

}
