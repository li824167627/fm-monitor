package com.fm.portal.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 审核门禁
 **/
public class CheckOrderParam {
	private String token; // 用户token
	@NotEmpty(message = "门禁id不能为空")
	private String oid; // 门禁id
	private String addrId; // 个人地址id
	@Pattern(regexp = "^1|2$", message = "状态不正确：1通过，2禁止")
	private String state; // 门禁状态：1通过，2禁止
	private String reason; // 审核拒绝原因

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setOid(String oid) {
 		this.oid = oid;
	}

	public String getOid() {
 		return oid;
	}

	public void setAddrId(String addrId) {
 		this.addrId = addrId;
	}

	public String getAddrId() {
 		return addrId;
	}

	public void setState(String state) {
 		this.state = state;
	}

	public String getState() {
 		return state;
	}

	public void setReason(String reason) {
 		this.reason = reason;
	}

	public String getReason() {
 		return reason;
	}

}
