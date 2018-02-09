package com.fm.portal.controller.res.bean;


/**
 * image返回的信息
 **/
public class RFdfsFileBean {
	private String key; // 文件名
	private String group; // 组名
	private String groupPath; // 组内路径
	private String url; // 图片url地址
	private String format; // 文件格式

	public void setKey(String key) {
 		this.key = key;
	}

	public String getKey() {
 		return key;
	}

	public void setGroup(String group) {
 		this.group = group;
	}

	public String getGroup() {
 		return group;
	}

	public void setGroupPath(String groupPath) {
 		this.groupPath = groupPath;
	}

	public String getGroupPath() {
 		return groupPath;
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
