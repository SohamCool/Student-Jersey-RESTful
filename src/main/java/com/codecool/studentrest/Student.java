package com.codecool.studentrest;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
public class Student {
	private int id;
	private String name, dob, doj;
	
	public Student(int id, String name, String dob, String doj) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.doj = doj;
	}


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDob() {
		return dob;
	}

	public String getDoj() {
		return doj;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	@XmlElement
	public void setDoj(String doj) {
		this.doj = doj;
	}
	
		
}
