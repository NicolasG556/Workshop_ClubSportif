package com.clubsportif.users.service;

import com.clubsportif.users.entities.Role;
import com.clubsportif.users.entities.User;

public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
}