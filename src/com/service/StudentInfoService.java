package com.service;

import java.util.List;
import java.util.Map;

import com.entity.StudentInfo;

public interface StudentInfoService {
	int insert(StudentInfo student);

	int delete(int studentId);

	StudentInfo selectById(int studentId);

	List<StudentInfo> selectAll();

	StudentInfo selectByUsernamePassword(String username,String password);

	List<StudentInfo> selectByMajorName(String majorName);

	int update(StudentInfo student);
}
