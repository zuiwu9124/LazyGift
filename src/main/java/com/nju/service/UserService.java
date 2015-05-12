package com.nju.service;

/**
 * 用于处理有关用户的逻辑操作
 * @author Wangy
 *
 */
public interface UserService {

	
	/**
	 * 用户登录操作
	 * @param username 用户名
	 * @param password 密码
	 * @return true:登录成功,false:登录失败
	 */
	public boolean login(String username, String password);
	
}
