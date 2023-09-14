package com.lvg.spsec.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
 @EnableWebSecurity
 @EnableMethodSecurity
public class AppSecurityConfig
{
 @Bean
  public PasswordEncoder encoder()
  {
	  return new BCryptPasswordEncoder();
  }
	
 @Bean
  public UserDetailsService userDetailsService(PasswordEncoder encoder)
  {
	 UserDetails user= User.withUsername("ajay")
	 .password(encoder.encode("Ajay123"))
	 .roles("USER")
	 .build();
	 
	 
	 UserDetails admin = User.withUsername("Dinesh")
			 .password(encoder.encode("dinesh23"))
			 .roles("ADMIN","USER")
			 .build();
	 return new InMemoryUserDetailsManager(admin,user);
			 
  }
 @Bean
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
 {
	return  http.csrf().disable().authorizeHttpRequests().requestMatchers("employee/id").permitAll().and().authorizeHttpRequests().requestMatchers("/employee/**").authenticated().and().
	 httpBasic().and().build();
 
 }
 
}
