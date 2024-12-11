package com.project.Bean;

public class StudentBean {
private int id;
private String name;
private int age;
private long mobile;
private String address;
private String email;
private String course;

public StudentBean(int id, String name, int age, long mobile, String address, String email, String course) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.mobile = mobile;
	this.address = address;
	this.email = email;
	this.course = course;
}

public StudentBean( String name, int age,long mobile, String address, String email, String course) {
	super();
	this.name = name;
	this.age=age;
	this.mobile = mobile;
	this.address = address;
	this.email = email;
	this.course = course;
}

public StudentBean(long mobile) {
	super();
	this.mobile = mobile;
}


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

}
