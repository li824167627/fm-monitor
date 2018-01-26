package com.fm.app.controller.springmvc.req;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 文件-上传文件
 **/
public class UploadFileParam {
	@NotEmpty(message = "media_id不能为空！")
	private String media_id; // 微信的media_id

	public void setMedia_id(String media_id) {
 		this.media_id = media_id;
	}

	public String getMedia_id() {
 		return media_id;
	}

}
