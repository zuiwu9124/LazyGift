package com.nju.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="goods")
public class GoodsDO {

	private long id;
	private int level;
	private long parentId;
	private String name;
	private String pos;
	private String remark;
	private int num;
	
	public GoodsDO() {
		super();
	}

	public GoodsDO(long id, int level, long parentId, String name, String pos, String remark,
			int num) {
		super();
		this.id = id;
		this.level = level;
		this.parentId = parentId;
		this.name = name;
		this.pos = pos;
		this.remark = remark;
		this.num = num;
	}

	@Id 
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	@Column(name="level")
	public int getLevel() {
		return level;
	}

	@Column(name="parend_id")
	public long getParentId() {
		return parentId;
	}

	@Column(name="name", length=100)
	public String getName() {
		return name;
	}

	@Column(name="pos",length=200)
	public String getPos() {
		return pos;
	}

	@Column(name="remark", length=200)
	public String getRemark() {
		return remark;
	}

	@Column(name="num")
	public int getNum() {
		return num;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
