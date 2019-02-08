package test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.dal.StudentInfoDao;
import com.entity.StudentInfo;
import com.util.SQLSessionUtil;

class StudentInfoDaoTest {

	StudentInfoDao dao = SQLSessionUtil.getSqlSession().getMapper(StudentInfoDao.class);

	@Test
	void testInsert() {
		StudentInfo student = new StudentInfo();
		for (int i = 1; i < 10; i++) {
			student.setUsername("测试学生" + i);
			student.setPassword("123");
			student.setMajorName("测试专业" + i);
			student.setElseInfomation("其他信息测试" + i);
			System.out.println(dao.insert(student));
		}
	}

	@Test
	void testDelete() {
		System.out.println(dao.delete(1));
	}

	@Test
	void testSelectById() {
		System.out.println(dao.selectById(1));
	}

	@Test
	void testSelectAll() {
		System.out.println(dao.selectAll());
	}

	@Test
	void testSelectByUsernamePassword() {
		Map<String, String> map = new HashMap<>();
		map.put("username", "测试学生1");
		map.put("password", "123");
		System.out.println(dao.selectByUsernamePassword(map));
	}

	@Test
	void testSelectByMajorName() {
		System.out.println(dao.selectByMajorName("测试专业2"));
	}

	@Test
	void testUpdate() {
		StudentInfo student = new StudentInfo();
		student.setStudentId(1);
		student.setUsername("修改测试");
		student.setPassword("1234");
		System.out.println(dao.update(student));
	}

}
