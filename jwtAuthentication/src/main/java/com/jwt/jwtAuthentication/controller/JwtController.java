package com.jwt.jwtAuthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.jwtAuthentication.config.JwtUtil;
import com.jwt.jwtAuthentication.model.JwtReponse;
import com.jwt.jwtAuthentication.model.JwtRequest;
import com.jwt.jwtAuthentication.service.CustomerDetailsService;

@RestController
public class JwtController {
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("welcome")
	public String welcome() {
		
		String str= "accessible only for authorized users";
		
		return str;
		
	}
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwt) throws Exception{
		
		System.out.println(jwt);
		try {
			
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwt.getusername(), jwt.getPassword()));
			
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}catch(BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
		UserDetails userDetails=this.customerDetailsService.loadUserByUsername(jwt.getusername());
		
		String token=this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT "+token);
		
		return ResponseEntity.ok(new JwtReponse(token));
		
	}

}
