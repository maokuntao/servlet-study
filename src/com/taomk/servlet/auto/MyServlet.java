package com.taomk.servlet.auto;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 * @author taomk 2017-6-27 16:40
 */
@WebServlet("/lifeCycle")
public class MyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		System.out.println("com.taomk.servlet.auto.MyServlet's constructor invoked.");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("com.taomk.servlet.auto.MyServlet.init() invoked.");
		super.init();
	}
    
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("com.taomk.servlet.auto.MyServlet.getServletConfig() invoked.");
		return super.getServletConfig();
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("com.taomk.servlet.auto.MyServlet.service(ServletRequest, ServletResponse) invoked.");
		super.service(req, res);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("com.taomk.servlet.auto.MyServlet.doGet(ServletRequest, ServletResponse) invoked.");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("com.taomk.servlet.auto.MyServlet.doPost(ServletRequest, ServletResponse) invoked.");
		doGet(request, response);
	}
	
	@Override
	public String getServletInfo() {
		System.out.println("com.taomk.servlet.auto.MyServlet.getServletInfo() invoked.");
		String servletInfo = super.getServletInfo();
		System.out.println("\tservletInfo : " + servletInfo);
		return servletInfo;
	}

	@Override
	public void destroy() {
		System.out.println("com.taomk.servlet.auto.MyServlet.destroy() invoked.");
		super.destroy();
	}
}
