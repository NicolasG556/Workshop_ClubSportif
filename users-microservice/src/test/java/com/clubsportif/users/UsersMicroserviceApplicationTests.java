package com.clubsportif.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clubsportif.users.entities.User;
import com.clubsportif.users.repos.UserRepository;

@SpringBootTest
class UsersMicroserviceApplicationTests {
	
	@Autowired
	UserRepository userRepository;

	@Test
	public void testFindUserByUsername(){ 
		User user = userRepository.findByUsername("nicolas");
		
		System.out.println(user);
	}
	

}
