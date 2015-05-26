package com.nju.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lazy_order")
public class OrderDO {
	
	private long id;
	private long staffId;
	private int state;
	
	public OrderDO() {

	}
	
	public OrderDO(long staffId, int state) {
		super();
		this.staffId = staffId;
		this.state = state;
	}

	@Id 
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	@Column(name="staff_id")
	public long getStaffId() {
		return staffId;
	}
	
	@Column(name="state")
	public int getState() {
		return state;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}

	public void setState(int state) {
		this.state = state;
	}

}
