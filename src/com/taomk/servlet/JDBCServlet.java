package com.taomk.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taomk.dao.UserDao;

/**
 * @author taomk 2017年7月1日 上午12:00:24
 *
 */
//@WebServlet("jdbcServlet")
public class JDBCServlet extends HttpServlet {

	private static final long serialVersionUID = -8278092132876071324L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String firstName = new String(req.getParameter("firstName").getBytes("ISO8859-1"),"UTF-8");

		int updateCount = new UserDao().updateFirstNameByid(firstName, id);

		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		resp.getWriter().append("<p>更新了<font color=\"red\">" + updateCount + "</font>条数据<p>");
	}

}
