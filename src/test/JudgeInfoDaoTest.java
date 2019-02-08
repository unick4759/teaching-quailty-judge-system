package test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.dal.JudgeInfoDao;
import com.entity.JudgeInfo;
import com.util.SQLSessionUtil;

class JudgeInfoDaoTest {

	JudgeInfoDao dao = SQLSessionUtil.getSqlSession().getMapper(JudgeInfoDao.class);

	@Test
	void testInsert() {
		JudgeInfo judge = new JudgeInfo();

		for (int num = 1; num < 10; num++) {
			judge.setTeacherId(num);
			judge.setStudentId(num+10);
			judge.setCourseName("课程测试" + num);
			String aa="1+1";
			judge.setOptionValue(aa);
            judge.setTotalScore(num*10);
            judge.setStudySummary("asdf张三,+lskfj"+num);
            int a=dao.insert(judge);
            if(a==1)
            {
            	System.out.println("插入成功");
            }
            else
            {
            	System.out.println("插入失败");
            }
		}

	}

	@Test
	void testDeleteByJudgeId() {
		System.out.println(1);

	}

	@Test
	void testDeleteByTeacherId() {
		JudgeInfo judge = new JudgeInfo();
		judge.setTeacherId(1);
		judge.setCourseName("根据教师id删除评价测试");
//		int num = dao.insert(judge);
//		if (num == 1) {
//			System.out.println("插入成功,课程名称为根据教师id删除评价测试，请进行删除测试");
//		}
		int num=dao.deleteByTeacherId(1);
		System.out.println(num);
	}

	@Test
	void testDeleteByStudentId() {
		JudgeInfo judge = new JudgeInfo();
		judge.setStudentId(1);
		judge.setCourseName("根据学生id删除评价测试");
//		int num = dao.insert(judge);
//		if (num == 1) {
//			System.out.println("插入成功,课程名称为根据学生id删除评价测试，请进行删除测试");
//		}
		int num =dao.deleteByStudentId(5);
		System.out.println(num);
	}

	@Test
	void testDeleteByCourseName() {
		JudgeInfo judge = new JudgeInfo();
		judge.setCourseName("根据课程名称删除测试");
//		int num = dao.insert(judge);
//		if (num == 1) {
//			System.out.println("插入成功，课程名为根据课程名称删除测试，请继续进行删除测试");
//		}
		int num=dao.deleteByCourseName("课程测试7");
		System.out.println(num);
	}

	@Test
	void testSelectByJudgeId() {
		System.out.println(dao.selectByJudgeId(1));
	}

	@Test
	void testSelectAll() {
		System.out.println(dao.selectAll());
	}

	@Test
	void testSelectByTeacherId() {
		System.out.println(dao.selectByTeacherId(1));
	}

	/**
	 * 这个东西要写在对应的serviceImpl中
	 */
	@Test
	void testSelectByTeacherIdAndCourseName() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("teacherId", 1);
		map.put("courseName", "课程测试1");
		System.out.println(dao.selectByTeacherIdAndCourseName(map));
	}

	@Test
	void testSelectByStudentId() {
		System.out.println(dao.selectByStudentId(1));
	}

	@Test
	void testSelectByStudentIdAndCourseName() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("studentId", 2);
		map.put("courseName", "课程测试2");
		System.out.println(dao.selectByStudentIdAndCourseName(map));
	}

	@Test
	void testSelectByTotalScore() {
		for (int i = 1; i < 5; i++) {
			JudgeInfo judge = new JudgeInfo();
			judge.setTotalScore(0);
			judge.setCourseName("测试按照总分查找评价");
			dao.insert(judge);
		}
		System.out.println(dao.selectByTotalScore(0));
	}

	@Test
	void testSelectBystudySummary() {
		for (int i = 1; i < 5; i++) {
			JudgeInfo judge = new JudgeInfo();
			judge.setStudySummary("张晓辉");
			dao.insert(judge);
		}
		System.out.println(dao.selectBystudySummary("张晓辉"));
	}

	@Test
	void testUpdate() {
		JudgeInfo judge = new JudgeInfo();
		judge.setJudgeId(1);
		judge.setStudySummary("杨资宏");
		int num = dao.update(judge);
		System.out.println(num);
	}

}
