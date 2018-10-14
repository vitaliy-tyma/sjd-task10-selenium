package info.sjd.model;

import java.util.Arrays;

public class Account {

	private String email;
	private char[] password_chars;
	private String first_name;
	private String last_name;

	public Account() {
		super();
	}

	public Account(String email, char[] password_chars, String first_name, String last_name) {
		super();
		this.email = email;
		this.password_chars = password_chars;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/* Altered getter - toString.*/
	public String getPasswordString() {
		return new String(password_chars);
	}

	public void setPassword_chars(char[] password_chars) {
		this.password_chars = password_chars;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
}
