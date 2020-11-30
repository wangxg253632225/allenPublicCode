package com.dongnaoedu.poling.bean;

import java.io.Serializable;

/**
 * 用户信息
 * 
 * @author allen
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = -5190025603436708199L;

	private int id;
	private String username;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
