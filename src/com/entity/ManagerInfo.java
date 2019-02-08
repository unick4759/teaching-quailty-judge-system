package com.entity;

public class ManagerInfo {
	private int managerId;
	private String username;
	private String password;

	public ManagerInfo() {
		super();
	}

	public ManagerInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
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
		return "ManagerInfo [managerId=" + managerId + ", username=" + username + ", password=" + password + "]";
	}

}
