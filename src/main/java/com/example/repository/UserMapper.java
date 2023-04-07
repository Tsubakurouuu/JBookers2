package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.model.MUser;

@Mapper
public interface UserMapper {
	public int signup(MUser user);
	public List<MUser> index();
	public MUser show(int id);
	public void update(@Param("id") int id, @Param("name") String name, @Param("introduction") String introduction);
}
