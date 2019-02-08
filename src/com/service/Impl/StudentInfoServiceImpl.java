package com.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dal.StudentInfoDao;
import com.entity.StudentInfo;
import com.service.StudentInfoService;
import com.util.SQLSessionUtil;

public class StudentInfoServiceImpl implements StudentInfoService {

	StudentInfoDao dao = SQLSessionUtil.getSqlSession().getMapper(StudentInfoDao.class);

	@Override
	public int insert(StudentInfo student) {
		return dao.insert(student);
	}

	@Override
	public int delete(int studentId) {
		return dao.delete(studentId);
	}

	@Override
	public StudentInfo selectById(int studentId) {
		return dao.selectById(studentId);
	}

	@Override
	public List<StudentInfo> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<StudentInfo> selectByMajorName(String majorName) {
		return dao.selectByMajorName(majorName);
	}

	@Override
	public int update(StudentInfo student) {
		return dao.update(student);
	}

	@Override
	public StudentInfo selectByUsernamePassword(String username, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		return dao.selectByUsernamePassword(map);
	}

}
