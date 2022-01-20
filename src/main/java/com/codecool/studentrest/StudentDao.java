package com.codecool.studentrest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.Context;

public class StudentDao {
	List<Student> students;
	Connection con = null;
	ResultSet rs = null;
	Statement st = null;
	PreparedStatement pt = null;
	DBConnection dbcon = new DBConnection();
	
	public List<Student> getStudents(){
		List<Student> students = null;
		try {
			con=dbcon.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from STUDENT");
			students = new ArrayList<>();

			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String dob = rs.getString(3);
				String doj = rs.getString(4);
				
				students.add(new Student(id, name, dob, doj));
			}
			rs.close();
			st.close();
			con.close();
			
			return students;

		}catch(Exception e) {
			System.out.println(e);
		}
	
	return students;	
	}
	
	public String addStudent(int id, String name, String dob, String doj) {
		try {
			con=dbcon.getConnection();
			st = con.createStatement();
			int result = st.executeUpdate("insert into STUDENT values(" + id + ",'" + name + "','" + dob + "','" + doj + "')");
			if(result == 1)
				return (name+"'s data have been saved Successfully...");
			st.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return "Failed to save data";
	
	}
	
	public Student getStudent(int id) {
		 for(Student s : students) {
			 if(s.getId()==id)
				 return s;
		 }
			 return null;
		
	}
	
	
	
}
