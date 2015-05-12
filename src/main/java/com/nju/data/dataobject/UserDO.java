package com.nju.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Wangy
 *
 */
@Entity
@Table(name="user")
public class UserDO {
	
	private String username;
	private String password;
	
	public UserDO(){//必须有无参构造函数
		
	}

	public UserDO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Id 
	@Column(name="username", length=45, unique=true, nullable=false)
	public String getUsername() {
		return username;
	}
	
	@Column(name="password",length=45)
	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
