
package com.food101.project.theFood;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import data.AppUser;
import supply.Search;

public class userLoginService implements UserDetailsService {
	
	
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
/*
    Here we are using dummy data, you need to load user data from
     database or other third party application 
	  need change to search in firebase
*/
	  Search s = new Search();
    AppUser user;
	try {
		user = s.findUserbyUsername(username);
		
		
		if(user == null) {
			System.out.println("fuck off");
		}
		
	    UserBuilder builder = null;
	    if (user != null) {
	    	
	      builder = org.springframework.security.core.userdetails.User.withUsername(username);//username
	      
	      
	      System.out.println(new BCryptPasswordEncoder().encode(user.getEncrytedPassword()));
	      
	      
	     builder.password(new BCryptPasswordEncoder().encode(user.getEncrytedPassword()));
	     // builder.password(user.getEncrytedPassword()); //user.getEncrytedPassword()
	      builder.roles("user");
	      
	      Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
	            grantedAuthorities.add(new SimpleGrantedAuthority("user"));
	          
	        
	      
	     return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getEncrytedPassword(), grantedAuthorities);
	    
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }

	   // return builder.build();
	    
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
  }


  

  }
 
