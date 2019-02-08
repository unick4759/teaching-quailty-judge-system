package test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.dal.TeacherInfoDao;
import com.entity.TeacherInfo;
import com.util.SQLSessionUtil;

class TeacherInfoDaoTest {

	TeacherInfoDao dao = SQLSessionUtil.getSqlSession().getMapper(TeacherInfoDao.class);

	@Test
	void testInsert() {
		TeacherInfo teacher = new TeacherInfo();
		for (int i = 1; i < 10; i++) {
			teacher.setUsername("teacher" + i);
			teacher.setPassword("123");
			teacher.setTeacherName("teacherName" + i);
			teacher.setElseInfomation("其他信息" + i);
			int num = dao.insert(teacher);
			System.out.println(num);
		}
	}

	@Test
	void testDelete() {
		System.out.println(dao.delete(1));
	}

	@Test
	void testSelectByTeacherId() {
		System.out.println(dao.selectByTeacherId(2));
	}

	@Test
	void testSelectAll() {
		System.out.println(dao.selectAll());
	}

	@Test
	void testSelectByUsernamePassword() {
		TeacherInfo teacher=new TeacherInfo();
		Map<String,String>map=new HashMap<>();
		map.put("username", "teacher2");
		map.put("password", "123");
		
		System.out.println(dao.selectByUsernamePassword(map));
	}

	@Test
	void testUpdate() {
		TeacherInfo teacher=new TeacherInfo();
		teacher.setTeacherId(2);
		teacher.setPassword("修改测试");
		System.out.println(dao.update(teacher));
	}

}
