package com.shopme.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.shopme.admin.Repository.UserRepository;
import com.shopme.admin.security.ShopmeUserDetail;
import com.shopme.common.entity.User;

public class ShopmeUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	User userByEmail = userRepository.getUserByEmail(email);
	
	if (userByEmail != null) {
		return new ShopmeUserDetail(userByEmail);
	}
	
		throw new UsernameNotFoundException("Could not find user with email:" + email);
	}

}
