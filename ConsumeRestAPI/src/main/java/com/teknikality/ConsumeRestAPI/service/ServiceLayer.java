package com.teknikality.ConsumeRestAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.teknikality.ConsumeRestAPI.Entities.User;
import com.teknikality.ConsumeRestAPI.dao.IUserStoreDAO;

@Service
public class ServiceLayer implements IUserServices {
	
	@Autowired
	private IUserStoreDAO dao;
	
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public ServiceLayer(RestTemplate restTemplate) {
		
		this.restTemplate=restTemplate;
	}
	
	public User consumeApi() {
		
	 User u = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", User.class);
	 return u;
	}

	@Override
	public List<User> getUsers() {
		
		return dao.getUsers();
	}

	@Override
	public User getUser(int userId) {
		
		return dao.getUser(userId);
	}

	@Override
	public void saveUser(User user) {
		
	User u = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", User.class);
	dao.saveUser(u);
	System.out.println("User is saved");
	
	}

	@Override
	public boolean deleteUser(int userId) {

		return dao.deleteUser(userId);
	}

}
