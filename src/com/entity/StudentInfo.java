package com.entity;

public class StudentInfo {
	private int studentId;
	private String username;
	private String password;
	private int state;
	private String majorName;
	private String elseInfomation;

	public StudentInfo() {
		super();
	}

	public StudentInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public StudentInfo(String username, String password, String majorName) {
		super();
		this.username = username;
		this.password = password;
		this.majorName = majorName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getElseInfomation() {
		return elseInfomation;
	}

	public void setElseInfomation(String elseInfomation) {
		this.elseInfomation = elseInfomation;
	}

	@Override
	public String toString() {
		return "StudentInfo [studentId=" + studentId + ", username=" + username + ", password=" + password + ", state="
				+ state + ", majorName=" + majorName + ", elseInfomation=" + elseInfomation + "]";
	}

}
