package com.dal;

import java.util.List;
import java.util.Map;

import com.entity.JudgeInfo;

public interface JudgeInfoDao {
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

	List<JudgeInfo> selectByTeacherIdAndCourseName(Map map);

	List<JudgeInfo> selectByStudentId(int studentId);

	JudgeInfo selectByStudentIdAndCourseName(Map map);

	List<JudgeInfo> selectByTotalScore(int totalScore);

	List<JudgeInfo> selectBystudySummary(String studySummary);

	int update(JudgeInfo judgeInfo);

}
