package com.nju.data.dao;

import com.nju.data.dataobject.UserAddressDO;

public interface UserAddressDao {
	
	public boolean submitAddress(String user,String street,String building,String room,boolean isDefault); 
	

	public UserAddressDO getDefaultAddress(String user);
	
	public UserAddressDO[] getAllAddresses(String user);
}
