package test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.dal.MajorInfoDao;
import com.entity.MajorInfo;
import com.util.SQLSessionUtil;

class MajorInfoDaoTest {
	
	MajorInfoDao dao=SQLSessionUtil.getSqlSession().getMapper(MajorInfoDao.class);

	@Test
	void testInsert() {
		MajorInfo major=new MajorInfo();
		for(int i=0;i<10;i++) {
			major.setMajorName("专业测试"+i);
			System.out.println(dao.insert(major));
		}
	}

	@Test
	void testDelete() {
		System.out.println(dao.delete(1));
	}

	@Test
	void testSelectByMajorId() {
		System.out.println(dao.selectByMajorId(1));
	}

	@Test
	void testSelectAll() {
		System.out.println(dao.selectAll());
	}

	@Test
	void testUpdate() {
		MajorInfo major=new MajorInfo();
		major.setMajorId(2);
		major.setMajorName("语文");
		System.out.println(dao.update(major));
	}

}
