package com.entity;

public class JudgeInfo {
	private int judgeId;
	private int teacherId;
	private int studentId;
	private String courseName;
	private String optionValue;
	private int totalScore;
	private String studySummary;

	public JudgeInfo() {
		super();
	}

	public JudgeInfo(int teacherId, int studentId, String courseName, String optionValue, int totalScore,
			String studySummary) {
		super();
		this.teacherId = teacherId;
		this.studentId = studentId;
		this.courseName = courseName;
		this.optionValue = optionValue;
		this.totalScore = totalScore;
		this.studySummary = studySummary;
	}

	public int getJudgeId() {
		return judgeId;
	}

	public void setJudgeId(int judgeId) {
		this.judgeId = judgeId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public String getStudySummary() {
		return studySummary;
	}

	public void setStudySummary(String studySummary) {
		this.studySummary = studySummary;
	}

	@Override
	public String toString() {
		return "JudgeInfo [judgeId=" + judgeId + ", teacherId=" + teacherId + ", studentId=" + studentId
				+ ", courseName=" + courseName + ", optionValue=" + optionValue + ", totalScore=" + totalScore
				+ ", studySummary=" + studySummary + "]";
	}

}
