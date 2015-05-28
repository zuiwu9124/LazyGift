package com.nju.data.dataobject;

import java.sql.Timestamp;

import javax.persistence.*;

/**
 * @author Weih
 *
 */
@Entity
@Table(name="lazyorder")
public class OrderDO {

	private int orderId;
	private String userName;
	private double orderPrice;
	private Timestamp orderDeadline;
	private String orderDestiantion;
	private int orderGoodsId;
	private String orderState;
	private int erranderId;
	private Timestamp orderStartTime;
	
	
	public OrderDO() {//±ØÐëÓÐÎÞ²Î¹¹Ôìº¯Êýs
		
	}
	
	public OrderDO(String userName,double orderPrice,Timestamp orderDeadline,
			String orderDestiantion,int orderGoodsId,String orderState,int erranderId,Timestamp orderStartTime){
		super();
		this.userName = userName;
		this.orderPrice = orderPrice;
		this.orderDeadline = orderDeadline;
		this.orderDestiantion = orderDestiantion;
		this.orderGoodsId = orderGoodsId;
		this.orderState = orderState;
		this.erranderId = erranderId;
		this.orderStartTime = orderStartTime;
	}
	
	@Id
  	@Column(name = "order_id",length=11, unique = true, nullable = false)
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
    @Column(name ="user_name",unique = true)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
    
	@Column(name ="order_price",length = 11)
	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	@Column(name ="order_deadline")	
	public Timestamp getOrderDeadline() {
		return orderDeadline;
	}

	public void setOrderDeadline(Timestamp orderDeadline) {
		this.orderDeadline = orderDeadline;
	}

	@Column(name ="order_destiantion",length = 250)
	public String getOrderDestiantion() {
		return orderDestiantion;
	}

	public void setOrderDestiantion(String orderDestiantion) {
		this.orderDestiantion = orderDestiantion;
	}
	
	@Column(name ="order_goods_id",length = 11)
	public int getOrderGoodsId() {
		return orderGoodsId;
	}

	public void setOrderGoodsId(int orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}

	@Column(name ="order_state",length = 250)
	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	@Column(name ="errander_id",length = 11)
	public int getErranderId() {
		return erranderId;
	}

	public void setErranderId(int erranderId) {
		this.erranderId = erranderId;
	}

	@Column(name ="order_start_time",length=19)
	public Timestamp getOrderStartTime() {
		return orderStartTime;
	}

	public void setOrderStartTime(Timestamp orderStartTime) {
		this.orderStartTime = orderStartTime;
	}

}
