package com.capgemini.pojo;

public class LoginPOJO {
	private String username;
	private String password;
	public LoginPOJO() {
		super();
		
	}
	public LoginPOJO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	@Override
	public String toString() {
		return "LoginPOJO [username=" + username + ", password=" + password + "]";
	}
	


}
