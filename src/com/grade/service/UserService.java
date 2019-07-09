package com.grade.service;


import java.util.List;

import com.grade.po.User;

public interface UserService {

	public User getUserByNameNumber(User user);
	
	public List<User> getUsers();

	public User getUserByName(String userName);

	public void SaveUserList(List<User> userList);

	public void deleteUserList();
	
}
