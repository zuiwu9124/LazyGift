package com.nju.data.dao;

import com.nju.data.dataobject.UserDO;

/**
 * 关于用户的数据库调用接口
 * @author Wangy
 *
 */
public interface UserDao {

	public UserDO getUserByUsernameAndPassword(String username, String password);
}
