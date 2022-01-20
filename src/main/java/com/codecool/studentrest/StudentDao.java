package com.codecool.studentrest;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	List<Student> students;
	Connection con = null;
	ResultSet rs = null;
	Statement st = null;
	PreparedStatement pt = null;
	//DBConnection dbcon = new DBConnection();
	
	public StudentDao() {
	/*	students = new ArrayList<>();
		
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Soham");
		s1.setDob("2008-03-09");
		s1.setDoj("2014-03-04");
		
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Aniket");
		s2.setDob("2005-03-09");
		s2.setDoj("2012-03-04");
		
		students.add(s1);
		students.add(s2);	*/
	}
	
	public List<Student> getStudents(){
		students = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
			st = con.createStatement();
			rs = st.executeQuery("select * from STUDENT");
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
	
/*	public Student getStudent(int id) {
		 for(Student s : students) {
			 if(s.getId()==id)
				 return s;
		 }
			 return null;
		
	}

	public void create(Student s1) {
		// TODO Auto-generated method stub
		students.add(s1);
	}
	*/
}
