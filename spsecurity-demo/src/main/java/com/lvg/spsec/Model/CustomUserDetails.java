package com.lvg.spsec.Model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.lvg.spsec.Entity.Users;
 @Component
public class CustomUserDetails implements UserDetails {
	
	 private String password;
	  private String username;
	  private List<SimpleGrantedAuthority>  authorites;
	   public CustomUserDetails(Users users) {
		    username= users.getUsername();
			   password =users.getPassword();
	authorites =Arrays.stream(users.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	   }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
