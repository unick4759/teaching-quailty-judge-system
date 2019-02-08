package com.dal;

import java.util.List;

import com.entity.MajorInfo;

public interface MajorInfoDao {
	int insert(MajorInfo major);

	int delete(int majorId);

	MajorInfo selectByMajorId(int majorId);
	
	List<MajorInfo> selectAll();

	int update(MajorInfo major);
}
