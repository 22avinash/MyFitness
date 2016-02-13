package dataTransferObject;

import java.io.Serializable;

public class Person implements Serializable {
	private String user_id;
	private String fname;
	private String lname;
	private String email;
	
	public Person(String user_id, String fname, String lname, String email, long contact, String password) {
		this.user_id = user_id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
		this.password = password;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	private long contact;
	private String password;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
