package com.clubsportif.users.restControllers;
import java.lang.reflect.Method;
import java.util.List;import org.hibernate.mapping.MetaAttributable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clubsportif.users.entities.User;
import com.clubsportif.users.repos.UserRepository;
import com.clubsportif.users.service.UserService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserRestController {
	
	@Autowired
	UserRepository userRep;
	
	@Autowired
	UserService userServ; 
	
	@RequestMapping(path = "/all",method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userRep.findAll();
	 }
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable Long id) {
		return userServ.findUserById(id);
	 }
	
	@RequestMapping(method = RequestMethod.GET)
	public User getUserByUsername(@RequestParam(value = "username") String username) {
		return userServ.findUserByUsername(username); 
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
	
	@RequestMapping(path = "/addRoleToUser", method = RequestMethod.POST)
	public User addRoleToUser(@RequestBody RequestWrapper requestWrapper) {
		return userServ.addRoleToUser(requestWrapper.user.getUsername(), requestWrapper.role.getRole()); 
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteUserById(@PathVariable Long id) 
	{
		userServ.deleteUserById(id);
	}
	
	@RequestMapping(value = "usersRole/{idRole}", method = RequestMethod.GET)
	public List<User> getUserByRoleId(@PathVariable("idRole") Long idRole){
		return userServ.findUserByIdRole(idRole);
	}
	
	
	
	
	
	
	
	
	
}
