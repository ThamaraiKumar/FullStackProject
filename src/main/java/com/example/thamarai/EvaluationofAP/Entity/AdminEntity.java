package com.example.thamarai.EvaluationofAP.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class AdminEntity {
	
	@Id
	private String emailid;
	private String password;
//	 @Enumerated(EnumType.STRING)
//	    private Role role;

	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
