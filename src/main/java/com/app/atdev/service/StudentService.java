package com.app.atdev.service;

import java.util.List;
import com.app.atdev.pojos.Student;


public interface StudentService { // StudentService is a interface which defines all the methods of service layer which contains all the business logic methods. 
	
	public Student registeredStudent(Student student);
	
	public String removeStudent(Integer studentId);
	
	public Student updateStudentDetails(Student student,Integer studentId);
	
	public List<Student> getAllStudents();

}
