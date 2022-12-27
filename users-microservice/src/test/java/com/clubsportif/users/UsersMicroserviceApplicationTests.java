package com.clubsportif.users;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clubsportif.users.entities.Role;
import com.clubsportif.users.entities.User;
import com.clubsportif.users.repos.RoleRepository;
import com.clubsportif.users.repos.UserRepository;
import com.clubsportif.users.service.UserService;

@SpringBootTest
class UsersMicroserviceApplicationTests {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleRepository roleRepository;

	@Test
	public void testFindUserByUsername(){ 
		User user = userRepository.findByUsername("nicolas");
		
		System.out.println(user);
	}
	
	public void testaddRoleToUser() {
		
		User r = userRepository.findByUsername("nicolas");
		Role rol = roleRepository.findByRole("ADMIN"); 
		userService.addRoleToUser(r.getUsername(), rol.getRole()); 
		
		System.out.println(r);
	}
	
	/*public void testFindByUserIdRole() {
		List<User> users = userRepository.findByIdRole(3L);
				for(User u : users) {
					System.out.println(u);
				}
	}*/
	

}
