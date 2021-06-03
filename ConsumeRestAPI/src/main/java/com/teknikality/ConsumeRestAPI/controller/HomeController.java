package com.teknikality.ConsumeRestAPI.controller;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teknikality.ConsumeRestAPI.Entities.User;
import com.teknikality.ConsumeRestAPI.service.ServiceLayer;

@RestController
public class HomeController {

	private final ServiceLayer serviceLayer;

	@Autowired
	public HomeController(ServiceLayer serviceLayer) {

		this.serviceLayer = serviceLayer;

	}

	@GetMapping("/")
	public ResponseEntity<User> getData() {

		User user = (User) serviceLayer.consumeApi();
		System.out.println(user);
		System.out.println(user.getId());
		System.out.println(user.getTitle());
		System.out.println(user.getUserId());
		System.out.println(user.isCompleted());

	
		serviceLayer.saveUser(user);
		
		return new ResponseEntity(user, HttpStatus.OK);
		// return new ResponseEntity<User>(serviceLayer.consumeApi(), HttpStatus.OK);

	}
	
	@GetMapping("users")
	public ResponseEntity<List<User>> getUsers(){
		
		List<User> users = serviceLayer.getUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}

}
