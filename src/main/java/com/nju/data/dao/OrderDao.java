package com.nju.data.dao;

import com.nju.data.dataobject.OrderDO;

public interface OrderDao {
	
	public void save(OrderDO order);
	
	public OrderDO findOrderById(int orderId);
}
