package com.app.atdev.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.atdev.exception.CustomException;
import com.app.atdev.pojos.Student;
import com.app.atdev.repository.StudentRepository;

@Service	// @Service tells separation between business logic
@Transactional	// @Transactional automatically open the session,begin Transaction, perfrom CRUD , commit and close the session by spring boot.
public class StudentServiceImpl implements StudentService{ //StudentService is a class which implements all the methods of StudentService Interface.
	
	@Autowired
	private StudentRepository studentRepository; //here StudentRepository is a dependecny of StudentServiceImpl dependet class

	@Override
	public Student registeredStudent(Student student) {  // method to persist the object in the db which is coming from frontend.
		
		Student s1 = new Student();	//creating a null object which is referred by student s1 object 
		
		s1.setFirstName(student.getFirstName()); // s1 object set the firstName,lastName,gender and marks which is coming from frontend payload
		s1.setLastName(student.getLastName());
		s1.setGender(student.getGender());
		s1.setMarks(student.getMarks());
		
		return studentRepository.save(s1); 	// here studentRepository use the JpaRepository save() to persist data in the db.
	}

	@Override
	public String removeStudent(Integer studentId) { // this method delete the persist object from the db
		
		Student student = studentRepository.findById(studentId).orElseThrow(()->new CustomException("Student not present with the given ID : " + studentId)); // here studentRepository uses findById() method of JpaRepository to find 
		//sudent with ID if it exists then it will return the Student value otherwise it will return custom exception.
		 
		studentRepository.delete(student); // here studentRepository deleted a particular student object from the db. 
		return "Student record deleted successfully whose Id : "+studentId;
		
	}
	

	@Override
	public Student updateStudentDetails(Student student,Integer studentId) { // update method of student details which is taking two parameters first one is student object that tells which fields need to update  with whose student ID that is the second parameter
		
		Student oldStudent = studentRepository.findById(studentId).orElseThrow(()->new CustomException("Student not present with the given Id : "+studentId)); // here first find object of student by using student ID if it found then return the result
			// otherwise return the custom exception.
		
		
		if(student.getFirstName()!=null) // first checking the object came from the frontend that contains what fields need to update then after it will update and save it.
			oldStudent.setFirstName(student.getFirstName()); // updating the student field its firstName,lastName,and marks by new payload data.
		
		if(student.getLastName()!=null)
			oldStudent.setLastName(student.getLastName());
		
		if(student.getMarks()!=0.0)
			oldStudent.setMarks(student.getMarks());
		
		Student updatedStudent = studentRepository.save(oldStudent);
			
		return updatedStudent;
		
	}

	@Override
	public List<Student> getAllStudents() { // getAllStudents returns result of all exist students
		
		List<Student> students = studentRepository.findAll(); //findAll() method of JpaRepository return all saved records from the db.
		return students;
	}

}
