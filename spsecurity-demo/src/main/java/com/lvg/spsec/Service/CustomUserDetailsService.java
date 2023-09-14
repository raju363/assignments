package com.lvg.spsec.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lvg.spsec.Entity.Users;
import com.lvg.spsec.Model.CustomUserDetails;



public class CustomUserDetailsService  implements UserDetailsService{

	    @Autowired
	    UserService usersService;

		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Users u = usersService.getByUsername(username);

			if(u!=null) return new CustomUserDetails(u);

			throw new UsernameNotFoundException("User does not Exist");
		}

}

		

	


