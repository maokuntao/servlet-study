package com.taomk.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author taomk 2017年6月26日 下午10:16:10
 *
 */
public class DateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date now = new Date();
		resp.setContentType("text/html");
		java.io.PrintWriter writer = resp.getWriter();
		writer.write("now : " + now);
		writer.close();
	}
}
