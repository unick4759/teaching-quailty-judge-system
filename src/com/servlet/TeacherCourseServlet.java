package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.CourseInfo;
import com.entity.TeacherInfo;
import com.google.gson.Gson;
import com.service.CourseInfoService;
import com.service.Impl.CourseInfoServiceImpl;

/**
 * Servlet implementation class TeacherCourseServlet
 */
@WebServlet("/TeacherCourseServlet")
public class TeacherCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherCourseServlet() {
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
		TeacherInfo teacher = (TeacherInfo) session.getAttribute("user");
		int teacherId = teacher.getTeacherId();
		CourseInfoService service = new CourseInfoServiceImpl();
		List<CourseInfo> list = service.selectByTeacherId(teacherId);
		Gson gson = new Gson();
		String str = gson.toJson(list);
		response.getWriter().write(str);
	}

}
