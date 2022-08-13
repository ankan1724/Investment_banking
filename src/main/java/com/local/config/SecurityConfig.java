package com.local.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	 @Override 
	 protected void configure(HttpSecurity http) throws Exception {
	   http.authorizeRequests() .antMatchers("/banker/**").authenticated()
	  .antMatchers("/swagger-ui/**","/swagger-ui.html").permitAll()
	  .antMatchers("/users/**").permitAll() .and().formLogin().and().httpBasic();
	  
	  http.csrf().disable();
	  http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
	  STATELESS); 
	 }
	 
}