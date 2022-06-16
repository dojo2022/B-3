package model;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private String user_id;

	public LoginUser(String user_id) {
		super();
		this.user_id = user_id;
	}

	public LoginUser() {
		super();
		user_id = "";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
