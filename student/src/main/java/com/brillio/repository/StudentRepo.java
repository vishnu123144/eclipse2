package com.brillio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brillio.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
