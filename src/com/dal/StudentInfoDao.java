package com.dal;

import java.util.List;
import java.util.Map;

import com.entity.StudentInfo;

public interface StudentInfoDao {
	int insert(StudentInfo student);

	int delete(int studentId);

	StudentInfo selectById(int studentId);

	List<StudentInfo> selectAll();

	StudentInfo selectByUsernamePassword(Map map);

	List<StudentInfo> selectByMajorName(String majorName);

	int update(StudentInfo student);
}
