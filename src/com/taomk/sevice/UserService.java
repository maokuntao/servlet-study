package com.taomk.sevice;

import java.util.List;

import com.taomk.entity.User;

/**
 * @author taomk 2017年6月30日 下午6:26:44
 *
 */
public interface UserService {

	/**
	 * 根据人名来查找
	 * @param userName
	 * @return
	 */
	User findByName(String userName);
	
	/**
	 * 找出所有的用户
	 * @return
	 */
	List<User> findAll();
	
	/**
	 * 添加用户
	 * @param person
	 * @return
	 */
	int add(User user);
	
	/**
	 * 根据用户ID删除用户
	 * @param id
	 * @return
	 */
	int delById(String id);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	int update(User user);
}
