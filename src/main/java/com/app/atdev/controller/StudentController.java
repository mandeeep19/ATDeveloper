package com.app.atdev.controller;

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
import com.app.atdev.pojos.Student;
import com.app.atdev.service.StudentService;

@RestController		// It defines the Controller+ResponseBody 
@RequestMapping("/student")		// @RequestMapping handles all the request which comes with student followed by rest request
public class StudentController {
	
	@Autowired
	private StudentService studentService; // automatically springboot inject contoller's dependency at the booting time of application 
										 
	@GetMapping("/getAllStudents")		// @GetMapping handles request for coming from enduser for fetching all students data from the database
	public ResponseEntity<?> getAllStudents()
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.getAllStudents());	//use ResponseEntity set the status code and body of result which is using the studentService method that is  the dependency of the student controller that calls the service layer method.
	}
	
	@PostMapping("/registeredStudent")		// @PostMapping handles request for creating or registering new student which is not in the db with fields.
	public ResponseEntity<?> registeredStudent(@RequestBody Student student)	//@RequestBody contains all the fields or payload which is coming from frontend to persist in the db.
	{
		return ResponseEntity.ok(studentService.registeredStudent(student)); // use ResponseEntity set the status code and body of result from the backend studentService returns the student object after saving it. 
	}
	
	@DeleteMapping("/delete/{studentId}") 	// @DeleteMapping is one of the request handling rest http method which takes a ID as parameter that decides whose object is to be removed from the db.
	public ResponseEntity<?> removeStudent(@PathVariable Integer studentId) //@PathVariable takes a single parameter or payload from the frontend.
	{
		return ResponseEntity.status(HttpStatus.OK).body(studentService.removeStudent(studentId)); //studentService calls the Service layer method of StudentService to delete object permanently from db.
	}
	
	@PutMapping("/update/{studentId}") //@PutMapping updates the existing record in the db whose ID will match with the given method's Id parameter and takes one extra parameter of student object which comes from frontend.
	public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable Integer studentId) //here @RequestBody taking parameter of student which tells what is need to change in the existing record in the db.
	{
			return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudentDetails(student, studentId));  // studenService calls the service layer method to updated the existing record.				
	}

}
