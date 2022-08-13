package com.local.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USERS_DB")
public class Users {
	
	@Id
	private String email;
	private String password;
	private String role;
	private boolean activated;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public Users(String email, String password, String role, boolean activated) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.activated = activated;
	}
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
}
	
	
	

