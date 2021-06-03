package com.teknikality.ConsumeRestAPI.service;

import java.util.List;

import com.teknikality.ConsumeRestAPI.Entities.User;

public interface IUserServices {
	
	List<User> getUsers();
	User getUser(int userId);
	void saveUser(User user);
	boolean deleteUser(int userId);

}
