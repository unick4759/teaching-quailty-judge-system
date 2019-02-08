package com.dal;

import java.util.List;
import java.util.Map;

import com.entity.ManagerInfo;

public interface ManagerInfoDao {
	int insert(ManagerInfo manager);

	int delete(int managerId);

	ManagerInfo selectById(int managerId);

	ManagerInfo selectByUsernamePassword(Map map);

	List<ManagerInfo> selectAll();
	
	int update(ManagerInfo manager);
}
