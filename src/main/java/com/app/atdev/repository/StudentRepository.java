package com.app.atdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.atdev.pojos.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{ 
	//StudentRepository extends the JpaRepository which is one of the Implementor of Spring Data Jpa which has several inbuild
	// methods to perform CRUD automatically just by calling that method. 
}
