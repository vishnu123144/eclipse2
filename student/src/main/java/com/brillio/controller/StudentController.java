package com.brillio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.model.Student;
import com.brillio.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	
	@Autowired
	private StudentService service;
	
	
	@PostMapping("/saveStudentDetails")
	public ResponseEntity<?> saveStudentDetails(@RequestBody Student student) {
		Student details = service.saveStudentDetails(student);
		return new ResponseEntity<Student>(details,HttpStatus.OK);
	}
	
	@GetMapping("/getStudentDetails")
	public List<Student> getStudentDetails() {
		return service.getStudentDetails();
	}
	
	
	@GetMapping("/student/{id}")
	public Object getStudentById(@PathVariable Long id) {
		return service.getStudentById(id);
	}
	
	@PutMapping("/updateStudent")
	public Object updateStudentDetails(@RequestBody Student student) {
		return service.updateStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudentDetails(@PathVariable Long id)
	{
		Object s= service.deleteStudent(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
}
