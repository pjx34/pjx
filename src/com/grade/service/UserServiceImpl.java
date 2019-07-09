package com.grade.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grade.dao.UserMapper;
import com.grade.po.User;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;
	@Override
	public User getUserByNameNumber(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectByNameNumber(user);
	}
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userMapper.selectUsers();
	}
	@Override
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByName(userName);
	}
	@Override
	public void SaveUserList(List<User> userList) {
		// TODO Auto-generated method stub
		userMapper.addUserList(userList);
	}
	@Override
	public void deleteUserList() {
		// TODO Auto-generated method stub
		userMapper.deleteUserList();
	}


}
