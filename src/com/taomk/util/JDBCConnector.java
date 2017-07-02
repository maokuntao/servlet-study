package com.taomk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.taomk.entity.User;

/**
 * JDBC链接 Java DataBase Connector
 * 
 * @author taomk 2017年6月30日 下午6:45:50
 *
 */
public class JDBCConnector {

	Connection conn = null;

	public JDBCConnector(String ip, String port, String dbName, String userName, String pwd) {
		try {
			// 1, load mysql driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// 2, create connection
			String connectionURL = "jdbc:mysql://" + ip + ":" + port + "/" + dbName
					+ "?useUnicode=true&characterEncoding=utf-8";
			conn = DriverManager.getConnection(connectionURL, userName, pwd);

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public List<User> executeQuery(String querySql) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(querySql);
			while (rs.next()) {
				Long id = rs.getLong("id");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				String address = rs.getString("address");
				String city = rs.getString("city");
				int age = rs.getInt("age");

				User user = new User(id, lastName, firstName, address, city, age);
				userList.add(user);
			}
			return userList;
		} catch (SQLException ex) {
			System.err.println(ex);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
					stmt = null;
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
					rs = null;
				}
			}
		}
		return null;
	}

	public int executeUpdate(String updateSql) throws SQLException {

		Statement stmt = null;
		int updateCount = 0;

		try {
			stmt = conn.createStatement();
			if (!stmt.execute(updateSql)) {

				updateCount = stmt.getUpdateCount();
			}
			return updateCount;
		} catch (SQLException ex) {
			System.err.println(ex);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
					stmt = null;
				}
			}
		}
		return updateCount;
	}

}
