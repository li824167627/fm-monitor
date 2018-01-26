package com.fm.app.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 设置公开地址
 **/
public class SetAddrShowParam {
	private String token; // 用户token
	@NotEmpty(message = "显示类型不能为空")
	@Pattern(regexp = "^0|1$", message = "类型不正确，1显示 0不显示")
	private String showType; // 显示类型：1显示 0不显示
	@NotEmpty(message = "地址id不能为空")
	private String aid; // 地址id

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setShowType(String showType) {
 		this.showType = showType;
	}

	public String getShowType() {
 		return showType;
	}

	public void setAid(String aid) {
 		this.aid = aid;
	}

	public String getAid() {
 		return aid;
	}

}
