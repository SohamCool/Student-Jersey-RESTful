package com.codecool.studentrest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public List<Student> getStudent(int id) {
		List<Student> students = null;
		try {
			con=dbcon.getConnection();
			pt = con.prepareStatement("select * from STUDENT where STUDENT_ID =?");
			pt.setInt(1, id);
			rs = pt.executeQuery();
			students = new ArrayList<>();
			while (rs.next()) {
				int sid = rs.getInt(1);
				String name = rs.getString(2);
				String dob = rs.getString(3);
				String doj = rs.getString(4);
				
				students.add(new Student(sid, name, dob, doj));
				System.out.println("inside getStudent search student"+name);
			}
			pt.close();
			con.close();
			rs.close();
			return students;

		}catch(Exception e) {
			System.out.println(e);
		}
	
		return students;
		
	}
	
	public String delStudent(int id) {
		try {
			con = dbcon.getConnection();
		pt = con.prepareStatement("delete from STUDENT where STUDENT_NO=?");
		pt.setInt(1, id);
		int result = pt.executeUpdate();
		if(result == 1)
			return "Deleted Successfully";
		}catch(Exception e) {
		return "Failed to Delete";
		}
		return "Deleted Successfully";
	}
	
	public String updateStudent(int id, String name, String dob, String doj) {
		try {
			con=dbcon.getConnection();
			st = con.createStatement();
			pt = con.prepareStatement("update STUDENT set STUDENT_NAME=?,STUDENT_DOB=?,STUDENT_DOJ=? where STUDENT_NO=?");
			pt.setString(1, name);
			pt.setString(2, dob);
			pt.setString(3, doj);
			pt.setInt(4, id);
			pt.executeUpdate();
			st.close();
			con.close();
			return "Updated Successfully";
		}catch(Exception e) {
			System.out.println(e);
		}
		return "Failed to save data";
	
	}
	
}
