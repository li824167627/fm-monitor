package com.fm.portal.controller.springmvc.req;



/**
 * 获取来访门禁列表
 **/
public class GetComeOrderListParam {
	private String token; // 用户token
	private String time; // 搜索来访时间
	private String name; // 搜索姓名
	private Integer page; // 页码，默认从0开始
	private Integer pageSize; // 每页数量，默认20

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setTime(String time) {
 		this.time = time;
	}

	public String getTime() {
 		return time;
	}

	public void setName(String name) {
 		this.name = name;
	}

	public String getName() {
 		return name;
	}

	public void setPage(Integer page) {
 		this.page = page;
	}

	public Integer getPage() {
 		return page;
	}

	public void setPageSize(Integer pageSize) {
 		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
 		return pageSize;
	}

}
