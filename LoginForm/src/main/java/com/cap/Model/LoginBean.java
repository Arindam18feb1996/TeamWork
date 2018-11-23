package com.cap.Model;

public class LoginBean {
	
	private String userName;
	private String userPwd;
	
	
	public LoginBean() {
		
	}
	
	public LoginBean(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", userPwd=" + userPwd + "]";
	}
	
	
	

}
