package com.fm.app.controller.springmvc.req;



/**
 * 获取消息记录
 **/
public class GetMsgsParam {
	private String token; // 用户token
	private Integer type; // 类型筛选
	private Integer page; // 页码，默认从0开始
	private Integer pageSize; // 每页数量，默认20

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setType(Integer type) {
 		this.type = type;
	}

	public Integer getType() {
 		return type;
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
