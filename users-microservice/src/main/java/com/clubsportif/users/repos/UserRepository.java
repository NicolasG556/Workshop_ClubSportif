package com.clubsportif.users.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clubsportif.users.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

		User findByUsername(String username);

}
