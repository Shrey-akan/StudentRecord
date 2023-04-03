package com.demo;

public class Student {
	
	private int id;
	private String name;
	private String classsection;
	private int rollno;
	private long phonenum;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClasssection() {
		return classsection;
	}
	public void setClasssection(String classsection) {
		this.classsection = classsection;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public long getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(long phonenum) {
		this.phonenum = phonenum;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", classsection=" + classsection + ", rollno=" + rollno
				+ ", phonenum=" + phonenum + "]";
	}
	
	
}
