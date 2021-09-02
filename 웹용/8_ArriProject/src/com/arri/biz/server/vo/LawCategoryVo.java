package com.arri.biz.server.vo;

import java.io.Serializable;

public class LawCategoryVo implements Serializable{		// �з�
	private static final long serialVersionUID = 1L;
	private int lc_number;
	private String name;
	
	public LawCategoryVo() {
		super();
	}
	public LawCategoryVo(int lc_number, String name) {
		super();
		this.lc_number = lc_number;
		this.name = name;
	}
	
	public int getLc_number() {
		return lc_number;
	}
	public void setLc_number(int lc_number) {
		this.lc_number = lc_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lc_number;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LawCategoryVo other = (LawCategoryVo) obj;
		if (lc_number != other.lc_number)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "LawCategoryVo [lc_number=" + lc_number + ", name=" + name + "]";
	}	
}
