package com.clubsportif.core.service;

import java.util.List;

import com.clubsportif.core.entities.User;

public interface UserService {

	User saveUser(User u); 
	User updateUser(User u); 
	void deleteUser(User u); 
	void deleteUserById(Long id);
	User getUser(Long id); 
	List<User> getAllUsers(); 
	
}
