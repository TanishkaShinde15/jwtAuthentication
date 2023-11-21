package com.jwt.jwtAuthentication.model;

public class JwtReponse {
	private String token;
	
	public JwtReponse() {
		
	}

	public JwtReponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
