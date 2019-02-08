package com.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dal.ManagerInfoDao;
import com.entity.ManagerInfo;
import com.service.ManagerInfoService;
import com.util.SQLSessionUtil;

public class ManagerInfoServiceImpl implements ManagerInfoService {

	ManagerInfoDao dao = SQLSessionUtil.getSqlSession().getMapper(ManagerInfoDao.class);

	@Override
	public int insert(ManagerInfo manager) {
		return this.dao.insert(manager);
	}

	@Override
	public int delete(int managerId) {
		return this.dao.delete(managerId);
	}

	@Override
	public ManagerInfo selectById(int managerId) {
		return this.dao.selectById(managerId);
	}

	@Override
	public ManagerInfo selectByUsernamePassword(String username, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		return dao.selectByUsernamePassword(map);
	}

	@Override
	public List<ManagerInfo> selectAll() {
		return dao.selectAll();
	}

	@Override
	public int update(ManagerInfo manager) {
		return dao.update(manager);
	}
}
