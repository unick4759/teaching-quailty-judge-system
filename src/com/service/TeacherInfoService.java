package com.service;

import java.util.List;
import java.util.Map;

import com.entity.TeacherInfo;

public interface TeacherInfoService {
	int insert(TeacherInfo teacher);

	int delete(int teacherId);

	TeacherInfo selectByTeacherId(int teacherId);

	List<TeacherInfo> selectAll();

	TeacherInfo selectByUsernamePassword(String username,String password);

	int update(TeacherInfo teacher);
}
