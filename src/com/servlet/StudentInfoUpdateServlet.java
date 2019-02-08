package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.StudentInfo;
import com.google.gson.Gson;
import com.service.StudentInfoService;
import com.service.Impl.StudentInfoServiceImpl;

/**
 * Servlet implementation class StudentInfoUpdateServlet
 */
@WebServlet("/StudentInfoUpdateServlet")
public class StudentInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentInfoUpdateServlet() {
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
		// 取id,取值，发送json给servlet,servlet取值，存数据库，更新session的user.
		HttpSession session = request.getSession();
		StudentInfo student = (StudentInfo) session.getAttribute("user");
		student.setPassword(request.getParameter("password"));
		student.setMajorName(request.getParameter("majorName"));
		student.setElseInfomation(request.getParameter("elseInfomation"));
		StudentInfoService service = new StudentInfoServiceImpl();
		service.update(student);
		session.setAttribute("user", student);
		Gson gson = new Gson();
		String src = "update success";
		String str = gson.toJson(src);
		response.getWriter().write(str);
	}

}
