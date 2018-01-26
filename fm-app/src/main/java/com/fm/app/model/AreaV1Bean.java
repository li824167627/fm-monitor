package com.fm.app.model;

public class AreaV1Bean {

	private String aid;
	private Integer id;
	private Integer pid;
	private String name;
	private String alif;
	private String areacode;
	private Integer arealevel;
	private String typename;

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlif() {
		return alif;
	}

	public void setAlif(String alif) {
		this.alif = alif;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public Integer getArealevel() {
		return arealevel;
	}

	public void setArealevel(Integer arealevel) {
		this.arealevel = arealevel;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@Override
	public String toString() {
		return "AreaV1Bean [aid=" + aid + ", id=" + id + ", pid=" + pid + ", name=" + name + ", alif=" + alif
				+ ", areacode=" + areacode + ", arealevel=" + arealevel + ", typename=" + typename + "]";
	}

}
