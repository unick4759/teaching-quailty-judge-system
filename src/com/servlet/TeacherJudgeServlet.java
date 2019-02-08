package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.JudgeInfo;
import com.entity.TeacherInfo;
import com.google.gson.Gson;
import com.service.JudgeInfoService;
import com.service.Impl.JudgeInfoServiceImpl;

/**
 * Servlet implementation class TeacherJudgeServlet
 */
@WebServlet("/TeacherJudgeServlet")
public class TeacherJudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherJudgeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html);charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		JudgeInfoService js = new JudgeInfoServiceImpl();
		HttpSession session = request.getSession();
		TeacherInfo teacher = (TeacherInfo) session.getAttribute("user");
		int teacherId = teacher.getTeacherId();
		List<JudgeInfo> list = js.selectByTeacherId(teacherId);
		Gson gson = new Gson();
		String str = gson.toJson(list);
		response.getWriter().write(str);
	}

}
