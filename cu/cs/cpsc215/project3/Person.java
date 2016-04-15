package cu.cs.cpsc215.project3;

import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serialVersionUID = -6244605024815197113L;
	private String fname, lname, email, color;
	
	public Person(String a, String b, String c, String d) {
		this.fname = a;
		this.lname = b;
		this.email = c;
		this.color = d;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
