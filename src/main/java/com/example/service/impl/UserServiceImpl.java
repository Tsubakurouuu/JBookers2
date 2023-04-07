package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.MUser;
import com.example.repository.UserMapper;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;

	@Override
	public void signup(MUser user) {
		mapper.signup(user);
	}

	@Override
	public List<MUser> index() {
		return mapper.index();
	}

	@Override
	public MUser show(int id) {
		return mapper.show(id);
	}

	@Override
	public void update(int id, String name, String introduction) {
		mapper.update(id, name, introduction);
	}

}
