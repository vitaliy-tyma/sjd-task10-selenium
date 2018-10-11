package info.sjd.model;

public class Account {

	private String email;
	private String password;
	private String first_name;
	private String second_name;
		
	public Account() {
		super();
	}

	public Account(String email, String password, String first_name, String second_name) {
		super();
		this.email = email;
		this.password = password;
		this.first_name = first_name;
		this.second_name = second_name;
	}
	
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
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getSecond_name() {
		return second_name;
	}
	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}
	
	
	
}
