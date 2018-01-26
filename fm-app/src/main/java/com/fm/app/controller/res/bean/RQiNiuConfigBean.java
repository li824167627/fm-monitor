package com.fm.app.controller.res.bean;


/**
 * 七牛配置信息
 **/
public class RQiNiuConfigBean {
	private String token; // 七牛token
	private String qiniuLinkUrl; // 七牛链
	private String qiniuCDNUrl; // 七牛CDN链

	public void setToken(String token) {
 		this.token = token;
	}

	public String getToken() {
 		return token;
	}

	public void setQiniuLinkUrl(String qiniuLinkUrl) {
 		this.qiniuLinkUrl = qiniuLinkUrl;
	}

	public String getQiniuLinkUrl() {
 		return qiniuLinkUrl;
	}

	public void setQiniuCDNUrl(String qiniuCDNUrl) {
 		this.qiniuCDNUrl = qiniuCDNUrl;
	}

	public String getQiniuCDNUrl() {
 		return qiniuCDNUrl;
	}

}
