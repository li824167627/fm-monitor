package com.fm.app.model;

import java.sql.Timestamp;

/**
 * 用户车辆信息
 **/
public class CarInfoBean {
	private Integer id; // id
	private String userId; // 用户uid
	private String no; // 车牌号
	private String letter; // 第一个字符的首字母
	private Timestamp creatTime; // 创建时间 时间戳

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getNo() {
		return no;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getLetter() {
		return letter;
	}

	public Timestamp getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}

}
