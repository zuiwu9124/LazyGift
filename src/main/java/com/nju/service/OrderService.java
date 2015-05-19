package com.nju.service;

import java.util.List;

import com.nju.model.Order;

public interface OrderService {

	/**
	 * 根据工作人员id和订单状态获得属于该员工特定状态的订单
	 * @param staffId
	 * @param states
	 * @return
	 */
	public List<Order> getOrdersByStaffId(long staffId, String[] states);
}
