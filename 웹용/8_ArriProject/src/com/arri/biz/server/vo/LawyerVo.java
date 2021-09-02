package com.arri.biz.server.vo;

import java.io.Serializable;

public class LawyerVo implements Serializable{		//	��ȣ��
	private static final long serialVersionUID = 1L;
	private String phone_number;
	private String name;
	private String phrase;
	private String workPlace;
	private String lc_Name;
	private int lc_number;
	
	public LawyerVo() {
		super();
	}

	public LawyerVo(String phone_number, String name, String phrase, String workPlace, String lc_Name, int lc_number) {
		super();
		this.phone_number = phone_number;
		this.name = name;
		this.phrase = phrase;
		this.workPlace = workPlace;
		this.lc_Name = lc_Name;
		this.lc_number = lc_number;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getLc_Name() {
		return lc_Name;
	}

	public void setLc_Name(String lc_Name) {
		this.lc_Name = lc_Name;
	}

	public int getLc_number() {
		return lc_number;
	}

	public void setLc_number(int lc_number) {
		this.lc_number = lc_number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lc_Name == null) ? 0 : lc_Name.hashCode());
		result = prime * result + lc_number;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone_number == null) ? 0 : phone_number.hashCode());
		result = prime * result + ((phrase == null) ? 0 : phrase.hashCode());
		result = prime * result + ((workPlace == null) ? 0 : workPlace.hashCode());
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
		LawyerVo other = (LawyerVo) obj;
		if (lc_Name == null) {
			if (other.lc_Name != null)
				return false;
		} else if (!lc_Name.equals(other.lc_Name))
			return false;
		if (lc_number != other.lc_number)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone_number == null) {
			if (other.phone_number != null)
				return false;
		} else if (!phone_number.equals(other.phone_number))
			return false;
		if (phrase == null) {
			if (other.phrase != null)
				return false;
		} else if (!phrase.equals(other.phrase))
			return false;
		if (workPlace == null) {
			if (other.workPlace != null)
				return false;
		} else if (!workPlace.equals(other.workPlace))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LawyerVo [phone_number=" + phone_number + ", name=" + name + ", phrase=" + phrase + ", workPlace="
				+ workPlace + ", lc_Name=" + lc_Name + ", lc_number=" + lc_number + "]";
	}
	
	
}
