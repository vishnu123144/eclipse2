package com.brillio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.model.Student;
import com.brillio.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
	//inserting data
	public Student saveStudentDetails(Student student) {
		return repo.save(student);
	}
	
	//get
	public List<Student> getStudentDetails(){
		return repo.findAll();
	}
	//find by id
	public Object getStudentById(Long id) {
		Optional<Student> findById = repo.findById(id);
		if(findById.isEmpty()) {
			return "student details could not found with given id" +id;
		}else {
			return findById.get();
		}
	}
	
	//update
	public Object updateStudent(Student student){
		Long id=student.getId();
		Object studentDuplicate =getStudentById(id);
		if(studentDuplicate!=null && !studentDuplicate.equals("student details could not found with given id")) {
			Student st=new Student();
			st.setId(student.getId());
			st.setName(student.getName());
			st.setEmail(student.getEmail());
			st.setMobile(student.getMobile());
			st.setCity(student.getCity());
			saveStudentDetails(student);
			return st;
	   }
		else {
			return "Student not present";
		}
	}
	
	public String deleteStudent(Long id) {
		Object id1=getStudentById(id);
		if(id1!=null && !id1.equals("student details could not found with given id")) {
			repo.delete((Student) id1);
			return "student deleted successfully";
		}else {
			return "student data not found";
		}
	}
	

}
