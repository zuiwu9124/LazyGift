package com.nju.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.nju.data.dao.OrderDao;
import com.nju.data.dao.UserDao;
import com.nju.data.dataobject.OrderDO;
import com.nju.data.dataobject.UserDO;
import com.nju.model.Order;
import com.nju.service.OrderManagerService;
import com.nju.util.DateUtil;

public class OrderManagerServiceImpl implements OrderManagerService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<Order> getOrdersByStaffId(long staffId, String[] states) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void saveOrder(OrderDO order) {
		// TODO Auto-generated method stub
		orderDao.save(order);
 	}
	
	@Override
	public String findOrder(int orderId) {
		OrderDO orderDo = orderDao.findOrderById(orderId);
		Gson gson = new Gson();
		String str = gson.toJson(orderDo);
		return str;		
	}
}
