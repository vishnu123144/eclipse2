package com.practice.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Employee;
import com.practice.service.EmployeeService;

//RestController is a combination of Controller + ResponseBody 

//Controller -> It is used to Handle the Requests and return the Views to Browser

//ResponseBody ->Generally In java we have objects so client cannot understand Object Directly so java is requesting to convert Object to Json.

//RestController ->Returns the Object which converts into JSON.(JavaScript Object Notation).


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getEmployeeDetails")
	public List<Employee> getEmployeeDetails(){
		return employeeService.getListOfEmployee();
	}
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<?> saveEmployeeDetails(@RequestBody Employee employee){
		Employee employeeD=employeeService.saveEmployeeDetails(employee);
		 return new ResponseEntity<Employee>(employeeD, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public Object getEmployeeById(@PathVariable Long id){
		Object e=employeeService.getEmployeeById(id);
		return e;
	}
	
	@PutMapping("/updateEmployee")
	public Object updateEmployeeDetails(@RequestBody Employee emp)	{
		Object obj=employeeService.updateEmployee(emp);
		return obj;
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployeeDetails(@PathVariable Long id){
		String o=employeeService.deleteEmployee(id);
//		return new ResponseEntity<Object>(o,HttpStatus.OK);
		return o;
	}
	
	
	//@PathVariable is used to extract the value passed from the URI(Uniform Resource Identifier).
	
	//This is how u will get the Answer for the This API
	//http://localhost:8085/foos/45---->Output: ID: 45
	//http://localhost:8085/foos/abc+d---->Output:ID: abc+d 
	
	
	//Check The Optiona and required for the Both Mappings
	@GetMapping("/foos/{id}")
	public String getFooById(@PathVariable String id) {
		return "ID: "+id;
	}
	
	
	//@RequestParam is used to extract the values from the Query String 
	//http://localhost:8085/flush?id=Bharath Katari----->Output: IDS: Bharath Katari
	//http://localhost:8085/flush?id=abc+d--->Output: IDS: abc d
	@GetMapping("/flush")
	public String getFlush(@RequestParam String id) {
		return "IDS: "+id;
	}
	
	
}
