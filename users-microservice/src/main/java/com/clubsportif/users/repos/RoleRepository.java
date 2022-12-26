package com.clubsportif.users.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.clubsportif.users.entities.Role;

@RepositoryRestResource(path = "ressource_role")
@CrossOrigin("*")
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRole(String role);
	
}