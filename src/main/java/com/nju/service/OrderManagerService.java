package com.nju.service;

import java.util.List;

import com.nju.data.dataobject.OrderDO;
import com.nju.model.Order;

public interface OrderManagerService {

	/**
	 * ��ݹ�����Աid�Ͷ���״̬������ڸ�Ա���ض�״̬�Ķ���
	 * @param staffId
	 * @param states
	 * @return
	 */
	public List<Order> getOrdersByStaffId(long staffId, String[] states);
	public void saveOrder(OrderDO order);
	public String findOrder(int OrderId);
}

