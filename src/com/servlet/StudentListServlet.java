package com.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html);charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		//HttpSession session=request.getSession();
		//ManagerInfo manager=(ManagerInfo)session.getAttribute("user");
		StudentInfoService ss=new StudentInfoServiceImpl();
		List<StudentInfo> list=ss.selectAll();
		//request.setAttribute("list", list);
		Gson gson=new Gson();
		String str=gson.toJson(list);
		response.getWriter().write(str);
		//request.getRequestDispatcher("/views/managerInfo/studentList.jsp").forward(request, response);
	}


}
