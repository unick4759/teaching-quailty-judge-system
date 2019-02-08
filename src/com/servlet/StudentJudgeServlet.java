package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.JudgeInfo;
import com.entity.StudentInfo;
import com.service.JudgeInfoService;
import com.service.Impl.JudgeInfoServiceImpl;

/**
 * Servlet implementation class StudentJudgeServlet
 */
@WebServlet("/StudentJudgeServlet")
public class StudentJudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentJudgeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从session中获得学生id，加传过来的课程名称，查找评价返回。
		// 怎么传过来课程名称呢，，得问一下。。。可以先完成评价页面等等其他东西。。
		// 不过评价是最重要的，并且教师也需要查看评价。
		response.setContentType("text/html);charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		StudentInfo student = (StudentInfo) session.getAttribute("user");

		int studentId = student.getStudentId();
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));// 通过urlget传过来的值。
		int insertNum;
		String courseName = request.getParameter("courseName");

		System.out.println("StudentJudgeServlet输出输出输出:" + studentId + teacherId + courseName);

		JudgeInfoService service = new JudgeInfoServiceImpl();
		JudgeInfo judge = service.selectByStudentIdAndCourseName(studentId, courseName);

		System.out.println("StudentJudgeServlet找到的评价.................:" + judge);

		if (judge == null) {// 为空说明没有这条评价，要insert
			judge = new JudgeInfo();// 先tm的初始化 20181210
			judge.setStudentId(studentId); // 20181210 对空指针进行操作，空指针异常，
			judge.setTeacherId(teacherId);
			judge.setCourseName(courseName);

			insertNum = service.insert(judge);
		} else if (judge != null) {
			// 如果为空，insert后request转发，不为空，则不操作,request转发。。
		}
		// if (judge != null) {// 如果还没评价则数据库中没有这条评价，增加评价。。
		// judge.setCourseName(courseName); //这行出错 500空指针异常 ，但是前台已经传过来了呀。。
		judge.setStudentId(studentId);
		judge.setTeacherId(teacherId);
		judge.setCourseName(courseName);// 如果数据库有的话，其他的值也不用装了。。数据库都有。。。
//		Gson gson = new Gson();
//		String str = gson.toJson(judge);
//		response.getWriter().write(str);
		// }else if(judge==null) {
		// JudgeInfo judge2 = new JudgeInfo();
		// judge2.set
		// }

		// 跳到另外一个页面..
		request.setAttribute("judge", judge);
		request.getRequestDispatcher("/views/studentInfo/studentJudge.jsp").forward(request, response);
	}

}
