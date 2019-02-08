package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.entity.ManagerInfo;
import com.entity.StudentInfo;
import com.entity.TeacherInfo;
import com.service.ManagerInfoService;
import com.service.StudentInfoService;
import com.service.TeacherInfoService;
import com.service.Impl.ManagerInfoServiceImpl;
import com.service.Impl.StudentInfoServiceImpl;
import com.service.Impl.TeacherInfoServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		//Class.forName(className)
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		JSONObject json=new JSONObject();
		int role = Integer.parseInt(request.getParameter("role"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("角色帐号密码:"+role+username+password);
		// 算了算了，就当踩坑。。。也不分开了，在这里吧。。。
		if (role == 0) {
			StudentInfoService studentService = new StudentInfoServiceImpl();
			StudentInfo student = studentService.selectByUsernamePassword(username, password);
			System.out.println("判断学生帐号密码");
			if (student != null) {
				System.out.println("学生帐号密码正确");
				HttpSession session = request.getSession();
				session.setAttribute("user", student);
				// request.setAttribute("user", student);
//				json.put("success", true);
//				json.put("msg", "登录成功");
//				json.put("user", student);
				System.out.println("跳转到学生界面");
				request.getRequestDispatcher("/views/studentInfo/studentIndex.jsp").forward(request, response);
			} else {
				json.put("success", false);
				json.put("msg", "帐号或密码错误");
				System.out.println("学生帐号密码错误");
				response.sendRedirect("error.html");
			}
		} else if (role == 1) {
			TeacherInfoService teacherService=new TeacherInfoServiceImpl();
			TeacherInfo teacher=teacherService.selectByUsernamePassword(username, password);
			System.out.println("判断教师帐号密码");
			if(teacher!=null) {
				System.out.println("教师帐号密码正确");
				HttpSession session=request.getSession();
				session.setAttribute("user", teacher);
				System.out.println("跳转到教师界面");
				request.getRequestDispatcher("/views/teacherInfo/teacherIndex.jsp").forward(request, response);
			}else {
				System.out.println("教师帐号密码错误");
				response.sendRedirect("error.html");
			}
		} else if (role == 2) {
			ManagerInfoService managerService=new ManagerInfoServiceImpl();
			ManagerInfo manager=managerService.selectByUsernamePassword(username, password);
			System.out.println("判断管理员帐号密码");
			if(manager!=null) {
				System.out.println("管理员帐号密码正确");
				HttpSession session=request.getSession();
				session.setAttribute("user", manager);
				System.out.println("同样增加到了session中，试试会不会跳转");
				request.getRequestDispatcher("/views/managerInfo/managerIndex.jsp").forward(request, response);
			}else {
				System.out.println("管理员帐号密码错误");
				response.sendRedirect("error.html");
			}
		}else {
			System.out.println();
			response.sendRedirect("error.html");
		}
	}

}
