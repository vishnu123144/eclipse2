package com.smartgig.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartgig.config.JwtTokenGenerator;
import com.smartgig.model.Login;
import com.smartgig.model.Registration;
import com.smartgig.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private JwtTokenGenerator token;
	
	@PostMapping("/register")
	public Object saveRegistration(@RequestBody Registration register) {
	return 	service.saveRegistration(register);
	}
	
	@GetMapping("/totalRegisters")
	public List<Registration> findAllMem(){
		return service.findAllTheRegisters();
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login) {
		String email=login.getEmail();
		String password=login.getPassword();
		boolean result = service.tryingToLogin(email, password);
		if(result==true) {	
		Map<String,String> map=token.generateToken(login);
        return ResponseEntity.status(201).body(map);
	}
		return null;
		
	}
}
