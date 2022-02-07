package com.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.model.Employee;
import com.practice.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	//Insert
	public Employee saveEmployeeDetails(Employee emp) {
		return repository.save(emp);
	}
	
	//Get
	public List<Employee> getListOfEmployee(){
		return repository.findAll();
	}
	
	//findById
	public Object getEmployeeById(Long id) {
		Optional<Employee> emp=repository.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		else {
			return "Employee Id is not present";
		}
	}
	
	//findByName
	public Object getEmployeeByName(String name) {
		Employee empName=repository.findByEmpName(name);
		if(empName!=null) {
			return empName;
		}
		else {
			return "Employee Not Present";
		}
		
	
	}
	
	//Delete
	public String deleteEmployee(Long id) {
		
		Object a=getEmployeeById(id);
		if((Employee)a!=null && !a.equals("Employee Id is not present")) {
			repository.delete((Employee)a);
			return "Employee Deleted Successfully";
		}
		else {
			return "Employee Not Present";
		}
		
	}
	
	//Update
	public Object updateEmployee(Employee emp) {
		Long id=emp.getEmpId();
		Object employeeDuplicate=getEmployeeById(id);
		if((Employee)employeeDuplicate!=null && !employeeDuplicate.equals("Employee Id is not present")) {
			Employee e=new Employee();
			e.setEmpId(emp.getEmpId());
			e.setEmpName(emp.getEmpName());
			e.setEmpEmail(emp.getEmpEmail());
			e.setEmpSalary(emp.getEmpSalary());
			saveEmployeeDetails(e);
			return e;
			
		}
		else {
			return "Employee Not Present";
		}
	}
}
