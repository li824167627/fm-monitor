package com.fm.portal.controller.res.bean;


/**
 * 版本升级信息
 **/
public class RVersionBean {
	private Integer id; // id
	private Integer vercode; // 版本号
	private String vername; // 版本名称
	private String url; // 下载url地址
	private String content; // 更新内容
	private Double fsize; // 更新大小
	private String fmd5; // 文件md5值
	private Long createTime; // 更新时间
	private Integer verport; // 版本端1用户端2管理端

	public void setId(Integer id) {
 		this.id = id;
	}

	public Integer getId() {
 		return id;
	}

	public void setVercode(Integer vercode) {
 		this.vercode = vercode;
	}

	public Integer getVercode() {
 		return vercode;
	}

	public void setVername(String vername) {
 		this.vername = vername;
	}

	public String getVername() {
 		return vername;
	}

	public void setUrl(String url) {
 		this.url = url;
	}

	public String getUrl() {
 		return url;
	}

	public void setContent(String content) {
 		this.content = content;
	}

	public String getContent() {
 		return content;
	}

	public void setFsize(Double fsize) {
 		this.fsize = fsize;
	}

	public Double getFsize() {
 		return fsize;
	}

	public void setFmd5(String fmd5) {
 		this.fmd5 = fmd5;
	}

	public String getFmd5() {
 		return fmd5;
	}

	public void setCreateTime(Long createTime) {
 		this.createTime = createTime;
	}

	public Long getCreateTime() {
 		return createTime;
	}

	public void setVerport(Integer verport) {
 		this.verport = verport;
	}

	public Integer getVerport() {
 		return verport;
	}

}
