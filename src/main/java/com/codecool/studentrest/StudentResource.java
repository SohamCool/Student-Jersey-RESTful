package com.codecool.studentrest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

@Path("/studentres")
public class StudentResource {
	StudentDao sr = new StudentDao();

	@GET
	@Path("/studlist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudents() {
		System.out.println("getStudents called");

		return sr.getStudents();// if not work change name getallstudents
	}

	@POST
	@Path("/addstud")
	@Produces(MediaType.APPLICATION_JSON)
	public String addStudent(@FormParam("id") int id, @FormParam("name") String name, @FormParam("dob") String dob,
			@FormParam("doj") String doj, @Context HttpServletResponse servletResponse) throws IOException {
		return sr.addStudent(id, name, dob, doj);
	}

	@GET
	@Path("/searchstud")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudent(@FormParam("id") int id, @Context HttpServletResponse servletResponse)
			throws IOException {
		return sr.getStudent(id);
	}

	@DELETE
	@Path("/deletestud")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteStudent(@FormParam("id") int id, @Context HttpServletResponse servletResponse)
			throws IOException, SQLException {
		return sr.delStudent(id);
	}

	@POST
	@Path("/updatestud")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateStudent(@FormParam("id") int id, @FormParam("name") String name, @FormParam("dob") String dob,
			@FormParam("doj") String doj, @Context HttpServletResponse servletResponse) throws IOException {
		return sr.updateStudent(id, name, dob, doj);
	}
}
