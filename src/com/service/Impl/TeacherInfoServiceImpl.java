package com.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dal.TeacherInfoDao;
import com.entity.TeacherInfo;
import com.service.TeacherInfoService;
import com.util.SQLSessionUtil;

public class TeacherInfoServiceImpl implements TeacherInfoService {

	TeacherInfoDao dao = SQLSessionUtil.getSqlSession().getMapper(TeacherInfoDao.class);

	@Override
	public int insert(TeacherInfo teacher) {
		return dao.insert(teacher);
	}

	@Override
	public int delete(int teacherId) {
		return dao.delete(teacherId);
	}

	@Override
	public TeacherInfo selectByTeacherId(int teacherId) {
		return dao.selectByTeacherId(teacherId);
	}

	@Override
	public List<TeacherInfo> selectAll() {
		return dao.selectAll();
	}

	@Override
	public int update(TeacherInfo teacher) {
		return dao.update(teacher);
	}

	@Override
	public TeacherInfo selectByUsernamePassword(String username, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		return dao.selectByUsernamePassword(map);
	}

}
