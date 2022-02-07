package com.smartgig.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartgig.model.Registration;
import com.smartgig.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public Object saveRegistration(Registration register) {
		Boolean result=findUserIsExistOrNot(register);
		if(result) {
			return "User is already Exist";
		}
		else {
			return repository.save(register);
		}
	}
	
	public boolean findUserIsExistOrNot(Registration register) {
		
		List<Registration> list=repository.findAll();
		String newEmail=register.getEmail();
//		return repository.findByEmail(newEmail);
		List<Registration> listR=list.stream().filter((a)->a.getEmail().equals(newEmail)).collect(Collectors.toList());
		if(listR.size()==0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public List<Registration> findAllTheRegisters(){
		return repository.findAll();
	}
	
	public boolean tryingToLogin(String email,String password) {
		Registration register=repository.findByEmailAndPassword(email, password);	
		if(register!=null) {
			return true;
		}
		else
		{
			return false;
		}
	}
}
