package com.codecool.studentrest;
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/studentres")
public class StudentResource {
	StudentDao sr = new StudentDao();
	
	@GET 
	@Path("/studlist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudents() {
		System.out.println("Get student called");
	
		return sr.getStudents();//if not work change name getallstudents
	}
	
/*	@POST
	@Path("student")
	public Student createStudent(Student s1) {
		System.out.println(s1);
		sr.create(s1);
		return s1;
	}
	*/
}
