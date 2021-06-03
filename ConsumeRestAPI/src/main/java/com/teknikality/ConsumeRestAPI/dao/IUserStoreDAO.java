package com.teknikality.ConsumeRestAPI.dao;

import java.util.List;
import com.teknikality.ConsumeRestAPI.Entities.User;


public interface IUserStoreDAO {
	
	List<User> getUsers();
	User getUser(int userId);
	void saveUser(User user);
	boolean deleteUser(int userId);

}
