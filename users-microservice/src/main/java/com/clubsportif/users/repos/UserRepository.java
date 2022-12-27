package com.clubsportif.users.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clubsportif.users.entities.Role;
import com.clubsportif.users.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

		User findByUsername(String username);
		@Query("SELECT u from User u JOIN u.roles r where r.role_id = ?1")
		List<User> findByIdRole(Long roleId); 
}
