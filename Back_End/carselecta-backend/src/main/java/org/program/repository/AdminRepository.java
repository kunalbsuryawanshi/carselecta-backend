package org.program.repository;

import org.program.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	public Admin findByUsernameAndPassword(String username, String password);
	public Admin findByUsername(String username);
}
