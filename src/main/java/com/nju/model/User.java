package com.nju.model;

/**
 * 用于负责用户对象的对外显示
 * @author Wangy
 *
 */
public class User {
	
	private String username;
	
	public User(){
		
	}
	
	public User(String username){
		this.username = username;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
