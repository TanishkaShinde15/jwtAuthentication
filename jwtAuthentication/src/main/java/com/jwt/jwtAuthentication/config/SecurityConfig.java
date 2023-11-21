package com.jwt.jwtAuthentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jwt.jwtAuthentication.service.CustomerDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomerDetailsService customerDetailsService;
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http
	        	.antMatcher("/**")
		        	.authorizeRequests()
		        	.antMatchers("/oauth/authorize**", "/login**", "/error**")
		        	.permitAll()
	        	.and()
	            	.authorizeRequests()
	            	.anyRequest().authenticated()
	        	.and()
	        		.formLogin().permitAll();
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    	
	    	auth.userDetailsService(customerDetailsService);
			/*
			 * auth .inMemoryAuthentication()
			 * .withUser("humptydumpty").password(passwordEncoder().encode("123456")).roles(
			 * "USER");
			 */
	    	
	    }

	    @Bean
	    public BCryptPasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	    	return this.authenticationManagerBean();
	    	
	    }

}
