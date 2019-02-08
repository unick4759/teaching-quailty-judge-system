package com.service;

import java.util.List;

import com.entity.MajorInfo;

public interface MajorInfoService {
	int insert(MajorInfo major);

	int delete(int majorId);

	MajorInfo selectByMajorId(int majorId);

	List<MajorInfo> selectAll();

	int update(MajorInfo major);
}
