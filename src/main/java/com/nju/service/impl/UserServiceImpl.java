package com.nju.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.nju.data.dao.UserDao;
import com.nju.data.dataobject.UserDO;
import com.nju.service.UserService;

/**
 * @author Wangy
 *
 */
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		UserDO userDo = userDao.getUserByUsernameAndPassword(username, password);
		
		return userDo==null?false:true;
	}

	

}
