package com.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long empId;
	
	private String empName;
	private String empEmail;
	private Double empSalary;
	public Long getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public Double getEmpSalary() {
		return empSalary;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}
	
}
