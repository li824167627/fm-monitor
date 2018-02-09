package com.fm.portal.controller.res.bean;


/**
 * image返回的信息
 **/
public class RImageBean {
	private String content; // 返回
	private String key; // key
	private String url; // 图片url地址
	private String format; // 文件格式

	public void setContent(String content) {
 		this.content = content;
	}

	public String getContent() {
 		return content;
	}

	public void setKey(String key) {
 		this.key = key;
	}

	public String getKey() {
 		return key;
	}

	public void setUrl(String url) {
 		this.url = url;
	}

	public String getUrl() {
 		return url;
	}

	public void setFormat(String format) {
 		this.format = format;
	}

	public String getFormat() {
 		return format;
	}

}
