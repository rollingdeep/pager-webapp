package com.xch.page.model;

import java.io.Serializable;
import java.util.Map;

public class Student implements Serializable{

	private static final long serialVersionUID = 5366915110510948103L;

	private int id;
	
	private String stuName;
	
	private int age;
	
	private int gender;
	
	private String address;

	
	public Student() {
		super();
	}

	public Student(Map<String,Object> map) {
		this.id = ((Number) map.get("id")).intValue();
		this.stuName = (String) map.get("stu_name");
		this.age = ((Number) map.get("age")).intValue();
		this.gender = ((Number) map.get("gender")).intValue();
		this.address = (String) map.get("address");
	}
	
	
	public Student(int id, String stuName, int age, int gender, String address) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
}
