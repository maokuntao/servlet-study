package com.taomk.dao;

/**
 * @author taomk 2017年6月30日 下午6:44:58
 *
 */
public class UserDao {

	public int updateFirstNameByid(String firstName, String id) {

		String updateQuery = "UPDATE `user` SET firstName='" + firstName + "' WHERE id = " + id;
		int updateCount = BaseDao.getInstance().executeUpdate(updateQuery);

		return updateCount;
	}
}
