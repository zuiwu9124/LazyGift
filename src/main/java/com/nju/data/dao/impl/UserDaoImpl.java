package com.nju.data.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


import com.nju.data.dao.UserDao;
import com.nju.data.dataobject.UserDO;

/**
 * @author Wangy
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	
	protected static Logger log = LoggerFactory.getLogger(UserDao.class);


	@SuppressWarnings("unchecked")
	@Override
	public UserDO getUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		log.debug("getting UserDO instance with username: " + username+",password: "+password);
		try {
			String sql = "from UserDO where username = '"+username+"' and password='"+password+"'";
			Session se = this.currentSession();
		
			Query q = se.createQuery(sql);
			List<UserDO> result = q.list();
			return result.size()==0?null:result.get(0);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}


}
