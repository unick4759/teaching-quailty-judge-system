package test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.dal.ManagerInfoDao;
import com.entity.ManagerInfo;
import com.util.SQLSessionUtil;

class ManagerInfoDaoTest {

	ManagerInfoDao dao = SQLSessionUtil.getSqlSession().getMapper(ManagerInfoDao.class);

	@Test
	void testInsert() {
		ManagerInfo manager = new ManagerInfo();
		for (int i = 1; i < 10; i++) {
			manager.setPassword("123");
			manager.setUsername("manager");
			System.out.println(dao.insert(manager));
		}
	}

	@Test
	void testDelete() {
		System.out.println(dao.delete(1));
	}

	@Test
	void testSelectById() {
		System.out.println(dao.selectById(2));
	}

	/**
	 * 这一段要写在service中。。。
	 */
	@Test
	void testSelectByUsernamePassword() {
		ManagerInfo manager = new ManagerInfo();
		manager.setUsername("manager");
		manager.setPassword("123");
		Map<String, String> map = new HashMap<>();
		map.put("username", "manager");
		map.put("password", "123");
		System.out.println(dao.selectByUsernamePassword(map));
	}

	@Test
	void testSelectAll() {
		System.out.println(dao.selectAll());
	}

	@Test
	void testUpdate() {
		ManagerInfo manager = new ManagerInfo();
		manager.setManagerId(2);
		manager.setUsername("manager");
		manager.setPassword("1234");
		System.out.println(dao.update(manager));
	}

}
