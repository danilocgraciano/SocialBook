package com.curso.socialbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("abc").roles("ADMIN").password("{noop}123").roles("PASSWORD");

	}
	
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic()
		.and()
		.csrf().disable();

	}
	
	

}