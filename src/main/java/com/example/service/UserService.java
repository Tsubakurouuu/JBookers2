package com.example.service;

import java.util.List;

import com.example.model.MUser;

public interface UserService {
	public void signup(MUser user);
	public List<MUser> index();
	public MUser show(int id);
	public void update(int id, String name, String introduction);
}
