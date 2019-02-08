package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.MajorInfo;
import com.google.gson.Gson;
import com.service.MajorInfoService;
import com.service.Impl.MajorInfoServiceImpl;

/**
 * Servlet implementation class MajorListServlet
 */
@WebServlet("/MajorListServlet")
public class MajorListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MajorListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html);charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		MajorInfoService ms = new MajorInfoServiceImpl();
		List<MajorInfo> list = ms.selectAll();
		Gson gson = new Gson();
		String str = gson.toJson(list);
		response.getWriter().write(str);
	}

}
