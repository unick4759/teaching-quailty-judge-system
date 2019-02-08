package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.TeacherInfo;
import com.google.gson.Gson;
import com.service.TeacherInfoService;
import com.service.Impl.TeacherInfoServiceImpl;

/**
 * Servlet implementation class TeacherInfoUpdateServlet
 */
@WebServlet("/TeacherInfoUpdateServlet")
public class TeacherInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherInfoUpdateServlet() {
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
		TeacherInfo teacher = (TeacherInfo) session.getAttribute("user");
		teacher.setPassword(request.getParameter("password"));
		teacher.setTeacherName(request.getParameter("teacherName"));
		teacher.setElseInfomation(request.getParameter("elseInfomation"));
		TeacherInfoService service = new TeacherInfoServiceImpl();
		service.update(teacher);
		session.setAttribute("user", teacher);
		Gson gson=new Gson();
		String src="update success";
		String str=gson.toJson(src);
		response.getWriter().write(str);
	}

}
