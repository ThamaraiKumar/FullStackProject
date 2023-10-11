package com.example.thamarai.EvaluationofAP.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="staffentity")
public class StaffEntity {
	
	@Column(unique=true)
	private int staffid;
	private String username;
	private String password;
	@Id
	private String emailid;
	private String gender;
	private String department;
	private String stafftype;
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStafftype() {
		return stafftype;
	}
	public void setStafftype(String stafftype) {
		this.stafftype = stafftype;
	}
	
	

}
