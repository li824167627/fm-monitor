package com.fm.app.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 用户认证
 **/
public class ApplyAuthParam {
	private String token; // 用户token
	@NotEmpty(message = "姓名不能为空")
	private String name; // 姓名
	@NotEmpty(message = "性别不能为空")
	@Pattern(regexp = "^1|2$", message = "性别不正确：1男，2女")
	private String gender; // 性别：1男，2女，不能为空
	@NotEmpty(message = "身份证号不能为空")
	private String idNo; // 身份证号
	@NotEmpty(message = "身份证信息不能为空")
	private String idInfo; // 身份证JSON

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setName(String name) {
 		this.name = name;
	}

	public String getName() {
 		return name;
	}

	public void setGender(String gender) {
 		this.gender = gender;
	}

	public String getGender() {
 		return gender;
	}

	public void setIdNo(String idNo) {
 		this.idNo = idNo;
	}

	public String getIdNo() {
 		return idNo;
	}

	public void setIdInfo(String idInfo) {
 		this.idInfo = idInfo;
	}

	public String getIdInfo() {
 		return idInfo;
	}

}
