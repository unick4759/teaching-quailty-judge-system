package test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.dal.CourseInfoDao;
import com.entity.CourseInfo;
import com.util.SQLSessionUtil;

class CourseInfoDaoTest {

	CourseInfoDao dao = SQLSessionUtil.getSqlSession().getMapper(CourseInfoDao.class);

	@Test
	void testInsert() {
		CourseInfo course=new CourseInfo();
		for(int num=0;num<10;num++) {
			course.setCourseName("课程测试"+num);
			course.setMajorName("专业测试"+num);
			course.setStudentId(num+10);
			course.setTeacherId(num);
			course.setTeacherName("teacherName"+num);
			int result=dao.insert(course);
			System.out.println(result);
		}
	}

	@Test
	void testDeleteByCourseId() {
		dao.deleteByCourseId(1);
	}

	@Test
	void testDeleteByCourseName() {
		dao.deleteByCourseName("语文");
	}

	@Test
	void testDeleteByMajorName() {
		dao.deleteByMajorName("软件工程");
	}

	@Test
	void testDeleteByTeacherId() {
		dao.deleteByTeacherId(1);
	}

	@Test
	void testSelectAll() {
		System.out.println(dao.selectAll());
//		dao.selectAll();
	}

	@Test
	void testSelectByCourseId() {
		dao.selectByCourseId(1);
	}

	@Test
	void testSelectByTeacherId() {
		dao.selectByTeacherId(1);
	}

	@Test
	void testSelectByCourseName() {
		dao.selectByCourseName("语文");
	}

	@Test
	void testSelectByMajorName() {
		dao.selectByMajorName("英语");
	}

	@Test
	void testUpdate() {
		CourseInfo course = new CourseInfo();
		dao.update(course);
	}

}
