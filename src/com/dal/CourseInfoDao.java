package com.dal;

import java.util.List;

import com.entity.CourseInfo;

public interface CourseInfoDao {
	int insert(CourseInfo course);

	int deleteByCourseId(int courseId);

	int deleteByCourseName(String courseName);

	int deleteByMajorName(String majorName);

	int deleteByTeacherId(int teacherId);

	int deleteByStudentId(int studentId);

	List<CourseInfo> selectAll();

	int selectByCourseId(int courseId);

	List<CourseInfo> selectByTeacherId(int teacherId);

	List<CourseInfo> selectByCourseName(String courseName);

	List<CourseInfo> selectByMajorName(String majorName);

	List<CourseInfo> selectByStudentId(int studentId);

	int update(CourseInfo course);

}
