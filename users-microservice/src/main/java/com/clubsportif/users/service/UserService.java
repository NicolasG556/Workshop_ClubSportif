package com.clubsportif.users.service;

import java.util.List;

import com.clubsportif.users.entities.Role;
import com.clubsportif.users.entities.User;

public interface UserService {
	User saveUser(User user);
	User updateUser(User user);
	void deleteUserById(Long id); 
	User findUserByUsername (String username);
	User findUserById (Long id); 
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
	List<User> findUserByIdRole(Long idRole); 
}