package com.jwt.jwtAuthentication.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		if(username.equals("Pallavi")) {
			return new User("Pallavi", "Pallavi#18", new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException(username);
		}
		
	}

}
