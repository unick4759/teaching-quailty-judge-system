package com.service;

import java.util.List;
import java.util.Map;

import com.entity.ManagerInfo;

public interface ManagerInfoService {
	int insert(ManagerInfo manager);

	int delete(int managerId);

	ManagerInfo selectById(int managerId);

	ManagerInfo selectByUsernamePassword(String username,String password);

	List<ManagerInfo> selectAll();

	int update(ManagerInfo manager);
}
