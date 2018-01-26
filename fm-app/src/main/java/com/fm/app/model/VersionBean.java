package com.fm.app.model;

import java.sql.Timestamp;

/**
 * 版本升级信息
 **/
public class VersionBean {
	private Integer id; // id
	private Integer vercode; // 版本号
	private String vername; // 版本名称
	private String url; // 下载url地址
	private String content; // 更新内容
	private Double fsize; // 更新大小
	private String fmd5; // 文件md5值
	private Timestamp createTime; // 更新时间
	private Integer verport; // 版本端1用户端2管理端

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVercode() {
		return vercode;
	}

	public void setVercode(Integer vercode) {
		this.vercode = vercode;
	}

	public String getVername() {
		return vername;
	}

	public void setVername(String vername) {
		this.vername = vername;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Double getFsize() {
		return fsize;
	}

	public void setFsize(Double fsize) {
		this.fsize = fsize;
	}

	public String getFmd5() {
		return fmd5;
	}

	public void setFmd5(String fmd5) {
		this.fmd5 = fmd5;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getVerport() {
		return verport;
	}

	public void setVerport(Integer verport) {
		this.verport = verport;
	}

}
