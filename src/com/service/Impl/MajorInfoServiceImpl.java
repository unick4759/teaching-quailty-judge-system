package com.service.Impl;

import java.util.List;

import com.dal.MajorInfoDao;
import com.entity.MajorInfo;
import com.service.MajorInfoService;
import com.util.SQLSessionUtil;

public class MajorInfoServiceImpl implements MajorInfoService {

	MajorInfoDao dao;

	public MajorInfoServiceImpl() {
		super();
		this.dao = SQLSessionUtil.getSqlSession().getMapper(MajorInfoDao.class);
	}

	@Override
	public int insert(MajorInfo major) {
		return this.dao.insert(major);
	}

	@Override
	public int delete(int majorId) {
		return this.dao.delete(majorId);
	}

	@Override
	public MajorInfo selectByMajorId(int majorId) {
		return this.selectByMajorId(majorId);
	}

	@Override
	public List<MajorInfo> selectAll() {
		return this.dao.selectAll();
	}

	@Override
	public int update(MajorInfo major) {
		return this.dao.update(major);
	}

}
