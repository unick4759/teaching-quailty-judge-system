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
import com.google.gson.Gson;
import com.service.JudgeInfoService;
import com.service.Impl.JudgeInfoServiceImpl;

/**
 * Servlet implementation class StudentJudgeUpdateServlet
 */
@WebServlet("/StudentJudgeUpdateServlet")
public class StudentJudgeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentJudgeUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html);charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		StudentInfo student = (StudentInfo) session.getAttribute("user");
		int studentId = student.getStudentId();
		String courseName = request.getParameter("courseName");
		String optionValue = request.getParameter("optionValue");
		int totalScore = Integer.parseInt(request.getParameter("totalScore"));
		JudgeInfoService service = new JudgeInfoServiceImpl();
		JudgeInfo judge = service.selectByStudentIdAndCourseName(studentId, courseName);

		int update_num = 0;
		int insert_num = 0;
		// 有就update没有就insert.
		// 肯定不为空啦，传来之前servlet为空也insert了，所以这里的处理只会是update...
		// update是根据id来的，所以要先获取judge对象，然后再赋值用户输入的表单值。。再update...
		// if (judge != null) {
		judge.setOptionValue(request.getParameter("optionValue"));
		judge.setTotalScore(Integer.parseInt(request.getParameter("totalScore")));
		judge.setStudySummary(request.getParameter("studySummary"));
		update_num = service.update(judge);
		
		response.sendRedirect("success.jsp");
		// } else if (judge == null) {
		// // 还没评价，数据库中没有这条评价，增加
		// JudgeInfo judge2 = new JudgeInfo();
		// judge2.setStudentId(studentId);
		// judge2.setTeacherId(Integer.parseInt(request.getParameter("teacherId")));
		// judge2.setCourseName(courseName);
		// judge2.setOptionValue(optionValue);
		// judge2.setTotalScore(totalScore);
		// insert_num = service.insert(judge2);
		// }

		// Gson gson = new Gson();
		// String src = "update judge success,update num:" + update_num + " insert num:"
		// + insert_num;
		// String str = gson.toJson(src);
		// response.getWriter().write(str);
	}

}
