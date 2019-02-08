package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/CharSetFilter")
public class CharSetFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		  HttpServletRequest  req=(HttpServletRequest) arg0;
		  HttpServletResponse  resp=(HttpServletResponse) arg1;
		  
		  
		  req.setCharacterEncoding("utf-8");
		  resp.setContentType("text/html;charset=utf-8");
		  resp.setCharacterEncoding("utf-8");
		  
		  arg2.doFilter(req, resp);
		  
		  
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
