package com.entity;

public class MajorInfo {
	private int majorId;
	private String majorName;

	public MajorInfo() {
		super();
	}

	public MajorInfo(String majorName) {
		super();
		this.majorName = majorName;
	}

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	@Override
	public String toString() {
		return "MajorInfo [majorId=" + majorId + ", majorName=" + majorName + "]";
	}

}
