package com.clubsportif.core;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clubsportif.core.entities.User;
import com.clubsportif.core.repository.UserRepository;

@SpringBootTest
class CoreApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testCreateUser() {
		User user1 = new User('M', "Guingouain", "Nicolas", "nicolas.guingouain@gmail.com", 1991, "135, Rue d'antrain", "35700", "Rennes", "France", "Jean123");
		userRepository.save(user1); 
	}
	
	@Test
	public void testFindUser() {
		User u = userRepository.findById(1L).get();
		System.out.println(u);
	}
	
	@Test
	public void testupdateUser() {
		User u = userRepository.findById(1L).get();
		u.setAdresse("1, Rue Isidore Louveau");
		userRepository.save(u); 
	}
	
	@Test
	public void testDeleteUser() {
		userRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAllUsers() {
		List<User> users = userRepository.findAll();
		
		for(User u:users) {
			System.out.println(u);
		}
	}
	
	@Test
	public void testfindUserByNom()
	{
		List<User> users = userRepository.findByNom("Dupont");
		
		for(User u:users) {
			System.out.println(u);
		}
		
	}
	
	@Test
	public void testfindUserByEmailMotDePasse() {
		List<User> users = userRepository.findByEmailMotDePasse("nicolas.guingouain@gmail.com", "Jean123"); 
		
		for(User u:users) {
			System.out.println(u);
		}
	}

	
}
