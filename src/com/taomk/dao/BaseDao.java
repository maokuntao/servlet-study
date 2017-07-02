package com.taomk.dao;

import java.sql.SQLException;
import java.util.List;

import com.taomk.entity.User;
import com.taomk.util.JDBCConnector;

/**
 * @author taomk 2017年6月30日 下午7:44:01
 *
 */
public class BaseDao {

	private static final String DB_IP = "127.0.0.1";
	private static final String DB_PORT = "3306";
	private static final String DB_NAME = "test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";

	JDBCConnector connecter;
	private static BaseDao singleInstance;

	private BaseDao() {
		connecter = new JDBCConnector(DB_IP, DB_PORT, DB_NAME, DB_USER, DB_PASSWORD);
	}

	public static synchronized BaseDao getInstance() {
		if (singleInstance == null) {
			singleInstance = new BaseDao();
			return singleInstance;
		}
		return singleInstance;
	}

	/**
	 * 执行查询类SQL，获取结果集
	 * 
	 * @param sql
	 *            查询类SQL
	 * @return UserList
	 */
	public List<User> executeQuery(String sql) {
		try {
			return connecter.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	/**
	 * 执行更新类SQL，获取影响行数
	 * 
	 * @param sql
	 *            更新类SQL
	 * @return 影响行数
	 */
	public int executeUpdate(String sql) {
		try {
			System.out.println("SQL : " + sql);
			return connecter.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(e);
			return 0;
		}
	}

	public static void main(String[] args) {
		
		String query = "SELECT * FROM `user`  WHERE id = 3";
		List<User> userList = BaseDao.getInstance().executeQuery(query);
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
		}
		
		String updateQuery = "UPDATE `user` SET firstName='陶茂坤' WHERE id = 3";
		int updateCount = BaseDao.getInstance().executeUpdate(updateQuery);
		System.out.println("更新了"+ updateCount + "条数据。");
		
		userList = BaseDao.getInstance().executeQuery(query);
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
		}
	}
}
