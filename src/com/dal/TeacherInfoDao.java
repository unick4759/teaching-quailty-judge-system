package com.dal;

import java.util.List;
import java.util.Map;

import com.entity.TeacherInfo;

public interface TeacherInfoDao {
	int insert(TeacherInfo teacher);

	int delete(int teacherId);

	TeacherInfo selectByTeacherId(int teacherId);

	List<TeacherInfo> selectAll();

	TeacherInfo selectByUsernamePassword(Map map);

	int update(TeacherInfo teacher);
}
