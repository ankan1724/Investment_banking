package com.local.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bankers_DB")
public class Banker {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BANKER_ID")
	private Long id;
	@Column(name="ACCOUNT_NUMBER")
	private Long accnumber;
	@Column(name="FIRST_NAME")
	private String firstname;
	@Column(name="LAST_NAME")
	private String lastname;
	@Column(name="EMAIL_ID")
	private String email;
	@Column(name="TOTAL_SHARE")
	private int totalshare;
	@Column(name="CLIENT_ID")
	private String clientid;
	@Column(name="CLIENT_SECRET")
	private String clientsecret;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTotalshare() {
		return totalshare;
	}
	public void setTotalshare(int totalshare) {
		this.totalshare = totalshare;
	}
	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public String getClientsecret() {
		return clientsecret;
	}
	public void setClientsecret(String clientsecret) {
		this.clientsecret = clientsecret;
	}
	
	public Long getAccnumber() {
		return accnumber;
	}
	public void setAccnumber(Long accnumber) {
		this.accnumber = accnumber;
	}
	public Banker() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Banker(Long id, Long accnumber, String firstname, String lastname, String email, int totalshare,
			String clientid, String clientsecret) {
		this.id = id;
		this.accnumber = accnumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.totalshare = totalshare;
		this.clientid = clientid;
		this.clientsecret = clientsecret;
	}}