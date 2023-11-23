package com.jwt.jwtAuthentication.model;

public class JwtRequest {
	private String username;
	private String password;
	
	public JwtRequest() {
		
	}
	
	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Jwt [username=" + username + ", password=" + password + "]";
	}
	
	

}
