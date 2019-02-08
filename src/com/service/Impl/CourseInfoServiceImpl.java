package com.service.Impl;

import java.util.List;

import com.dal.CourseInfoDao;
import com.entity.CourseInfo;
import com.service.CourseInfoService;
import com.util.SQLSessionUtil;

public class CourseInfoServiceImpl implements CourseInfoService {

	private CourseInfoDao dao;
	
	public CourseInfoServiceImpl() {
		super();
		this.dao = SQLSessionUtil.getSqlSession().getMapper(CourseInfoDao.class);
	}

	@Override
	public int insert(CourseInfo course) {
		return this.dao.insert(course);
	}

	@Override
	public int deleteByCourseId(int courseId) {
		return this.dao.deleteByCourseId(courseId);
	}

	@Override
	public int deleteByCourseName(String courseName) {
		return this.dao.deleteByCourseName(courseName);
	}

	@Override
	public int deleteByMajorName(String majorName) {
		return this.deleteByMajorName(majorName);
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
	public List<CourseInfo> selectAll() {
		return this.dao.selectAll();
	}

	@Override
	public int selectByCourseId(int courseId) {
		return this.dao.selectByCourseId(courseId);
	}

	@Override
	public List<CourseInfo> selectByTeacherId(int teacherId) {
		return this.dao.selectByTeacherId(teacherId);
	}

	@Override
	public List<CourseInfo> selectByCourseName(String courseName) {
		return this.dao.selectByCourseName(courseName);
	}

	@Override
	public List<CourseInfo> selectByMajorName(String majorName) {
		return this.selectByMajorName(majorName);
	}

	@Override
	public List<CourseInfo> selectByStudentId(int studentId) {
		return this.dao.selectByStudentId(studentId);
	}

	@Override
	public int update(CourseInfo course) {
		return this.update(course);
	}
	
}
