package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.MUser;
import com.example.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserService service;
	
//	private MUser m_user;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		MUser loginUser = service.login(name);
		
		if(loginUser == null) {
			throw new UsernameNotFoundException("user not found");
		}
		GrantedAuthority authority = new SimpleGrantedAuthority(loginUser.getName());
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(authority);
		
		UserDetails userDetails = (UserDetails) new User(loginUser.getName(), loginUser.getPassword(), authorities);
		return userDetails;
	}
	
//	public MUser getMUser() {
//		return m_user;
//	}
}
