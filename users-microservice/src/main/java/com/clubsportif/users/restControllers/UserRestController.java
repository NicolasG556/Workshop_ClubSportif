package com.clubsportif.users.restControllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clubsportif.users.entities.User;
import com.clubsportif.users.repos.UserRepository;
import com.clubsportif.users.service.UserService;


@RestController
@CrossOrigin(origins = "*")
public class UserRestController {
	
	@Autowired
	UserRepository userRep;
	
	@Autowired
	UserService userServ; 
	
	@RequestMapping(path = "all",method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userRep.findAll();
	 }
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable Long id) {
		return userServ.findUserById(id);
	 }
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		
		return userServ.saveUser(user);
	 }
	
	@RequestMapping(method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) 
	{
		return userServ.updateUser(user); 
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long id) 
	{
		userServ.deleteUserById(id); 
	}
	
	
	
	
	
	
	
	
	
}
