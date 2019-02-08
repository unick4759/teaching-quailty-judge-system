package com.service;

import java.util.List;
import java.util.Map;

import com.entity.JudgeInfo;

public interface JudgeInfoService {
	int insert(JudgeInfo judge);

	int deleteByJudgeId(int judgeId);

	int deleteByTeacherId(int teacherId);

	int deleteByStudentId(int studentId);

	int deleteByCourseName(String courseName);
	//
	// int deleteByTotalScore(int totalScore);
	//
	// int deleteByStudySummary(String studySummary);
	// 删除的方法不写那么多了。。。

	JudgeInfo selectByJudgeId(int judgeId);

	List<JudgeInfo> selectAll();

	List<JudgeInfo> selectByTeacherId(int teacherId);

	List<JudgeInfo> selectByTeacherIdAndCourseName(int teacherId,String courseName);

	List<JudgeInfo> selectByStudentId(int studentId);

	JudgeInfo selectByStudentIdAndCourseName(int studentId,String courseName);

	List<JudgeInfo> selectByTotalScore(int totalScore);

	List<JudgeInfo> selectBystudySummary(String studySummary);

	int update(JudgeInfo judgeInfo);
}
