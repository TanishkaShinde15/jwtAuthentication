package com.jwt.jwtAuthentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.jwtAuthentication.service.CustomerDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http.csrf().disable()
	    	.authorizeRequests()
	    	.antMatchers("/token")
	    	.permitAll()
	    	.anyRequest()
	    	.authenticated();
	    	
	    http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);	
	    
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    	
	    	auth.userDetailsService(customerDetailsService);
			
			/*
			 * auth .inMemoryAuthentication()
			 * .withUser("pallavi").password("Pallavi#18").roles(
			 * "USER");
			 */
			 
	    	
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder(){
	    	
	        return NoOpPasswordEncoder.getInstance();
	    }
	    
		
	
		@Bean 
		  public AuthenticationManager authenticationManagerBean() throws Exception {
			  return super.authenticationManagerBean();
		  }
		
	

}
