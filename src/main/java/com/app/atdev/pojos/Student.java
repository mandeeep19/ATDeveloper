package com.app.atdev.pojos;

//import all the required Classes
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter				// Used Lombok to import automatically All Constructor,Getter,Setter,toString for Student Pojo.
@Entity				// Hibernate will create automatically table with constraints in the specified db 
@Table(name="Student")	// Manually define the table name
public class Student {	
	
	@Id		// It defines that it is a primary key of table
	@GeneratedValue(strategy=GenerationType.IDENTITY) // GeneratedValue is used to auto_increment the id of student table
	private Integer id;
	
	//@NotBlank(message="firstName is required") // If I use @NotBlank annotations then when I try to update a particular filled then it need to fill the firstName, lastName as I mentioned @NotBlank therefore I comment it.
	@Column(name="firstName")		//@Column define the manual name of the database table column name
	private String firstName;
	
	//@NotBlank(message="lastName is required")
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	private double marks;

}
