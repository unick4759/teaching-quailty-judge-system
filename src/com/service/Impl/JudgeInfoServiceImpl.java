package com.service.Impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.dal.JudgeInfoDao;
import com.entity.JudgeInfo;
import com.service.JudgeInfoService;
import com.util.SQLSessionUtil;

public class JudgeInfoServiceImpl implements JudgeInfoService {

	private JudgeInfoDao dao;

	public JudgeInfoServiceImpl() {
		super();
		this.dao = SQLSessionUtil.getSqlSession().getMapper(JudgeInfoDao.class);
	}

	@Override
	public int insert(JudgeInfo judge) {
		return this.dao.insert(judge);
	}

	@Override
	public int deleteByJudgeId(int judgeId) {
		return this.dao.deleteByJudgeId(judgeId);
	}

	@Override
	public int deleteByTeacherId(int teacherId) {
		return this.dao.deleteByTeacherId(teacherId);
	}

	@Override
	public int deleteByStudentId(int studentId) {
		return this.dao.deleteByStudentId(studentId);
	}

	@Override
	public int deleteByCourseName(String courseName) {
		return this.dao.deleteByCourseName(courseName);
	}

	@Override
	public JudgeInfo selectByJudgeId(int judgeId) {
		return this.dao.selectByJudgeId(judgeId);
	}

	@Override
	public List<JudgeInfo> selectAll() {
		return this.dao.selectAll();
	}

	@Override
	public List<JudgeInfo> selectByTeacherId(int teacherId) {
		return this.dao.selectByTeacherId(teacherId);
	}

	@Override
	public List<JudgeInfo> selectByTeacherIdAndCourseName(int teacherId, String courseName) {
		Map<String, Object> map = new LinkedHashMap<>();

		return this.dao.selectByTeacherIdAndCourseName(map);
	}

	@Override
	public List<JudgeInfo> selectByStudentId(int studentId) {
		return this.dao.selectByStudentId(studentId);
	}

	@Override
	public List<JudgeInfo> selectByTotalScore(int totalScore) {
		return this.dao.selectByTotalScore(totalScore);
	}

	@Override
	public List<JudgeInfo> selectBystudySummary(String studySummary) {
		return this.dao.selectBystudySummary(studySummary);
	}

	@Override
	public int update(JudgeInfo judgeInfo) {
		return this.dao.update(judgeInfo);
	}

	@Override
	public JudgeInfo selectByStudentIdAndCourseName(int studentId, String courseName) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("studentId", studentId);
		map.put("courseName", courseName);
		return this.dao.selectByStudentIdAndCourseName(map);
	}

}
