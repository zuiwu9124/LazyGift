package com.nju.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.data.dataobject.OrderDO;
import com.nju.data.dataobject.UserDO;
import com.nju.service.OrderManagerService;
import com.nju.util.DateUtil;
import com.nju.util.ResponseBuilder;


@Controller
public class OrderController {
	
	@Autowired
	private OrderManagerService orderManagerService;
	
	@RequestMapping(value = "/confirmOrderSubmit",method = RequestMethod.GET) 
	public void teamLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ResponseBuilder rb = new ResponseBuilder();
		HttpSession session = request.getSession();
		UserDO account = (UserDO) session.getAttribute("cur_user");
		String userName = account.getUsername();
		String orderPrice = request.getParameter("orderPrice");
		double order_price = Double.parseDouble(orderPrice);
		String orderDestiantion = request.getParameter("orderDestiantion");
		String orderGoodsId = request.getParameter("orderGoodsId");
		int goods_id = Integer.parseInt(orderGoodsId);
		Timestamp orderStartTime = new Timestamp(new Date().getTime());
		String deadline_date = request.getParameter("deadlineDate");
		Timestamp deadlineDate = DateUtil.getTime(deadline_date);
		OrderDO order = new OrderDO(userName,order_price,deadlineDate,orderDestiantion,goods_id,"START",0,orderStartTime);
        try {
        	orderManagerService.saveOrder(order);	
			rb.writeJsonResponse(response, true);//µÚ¶þÎ»²ÎÊý²»ÄÜÎª×Ö·û´®
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
	}


}