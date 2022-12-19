package com.clubsportif.core.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clubsportif.core.entities.User;
import com.clubsportif.core.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserRESTController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") Long id) 
	{
		return userService.getUser(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
		
	}

}
