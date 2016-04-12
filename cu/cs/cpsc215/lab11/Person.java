package cu.cs.cpsc215.lab11;

import java.awt.Color;

public class Person {
	
	private String fname, lname, email;
	private Color favorite;
	
	public Person(String a, String b, String c, Color d) {
		this.fname = a;
		this.lname = b;
		this.email = c;
		this.favorite = d;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getEmail() {
		return email;
	}

	public Color getFavorite() {
		return favorite;
	}
}
