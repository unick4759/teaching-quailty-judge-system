package com.entity;

public class TeacherInfo {
	private int teacherId;
	private String username;
	private String password;
	private int state;
	private String teacherName;
	private String elseInfomation;

	public TeacherInfo() {
		super();
	}

	public TeacherInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public TeacherInfo(String username, String password, String teacherName) {
		super();
		this.username = username;
		this.password = password;
		this.teacherName = teacherName;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getElseInfomation() {
		return elseInfomation;
	}

	public void setElseInfomation(String elseInfomation) {
		this.elseInfomation = elseInfomation;
	}

	@Override
	public String toString() {
		return "TeacherInfo [teacherId=" + teacherId + ", username=" + username + ", password=" + password + ", state="
				+ state + ", teacherName=" + teacherName + ", elseInfomation=" + elseInfomation + "]";
	}

}
