package com.fm.app.controller.res.bean;


/**
 * 全国区域配置信息
 **/
public class RAreaBean {
	private String version; // 七牛token
	private String url; // 全国区域存放地址，json文件链接

	public void setVersion(String version) {
 		this.version = version;
	}

	public String getVersion() {
 		return version;
	}

	public void setUrl(String url) {
 		this.url = url;
	}

	public String getUrl() {
 		return url;
	}

}
