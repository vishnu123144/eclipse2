package com.smartgig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartgig.model.Registration;

@Repository
public interface UserRepository extends JpaRepository<Registration, String>{
	
	//QueryMethods
	boolean findByEmail(String email);
	Registration findByEmailAndPassword(String email,String password);
	
}
