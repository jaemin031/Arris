package com.arri.biz.server.vo;

import java.io.Serializable;
import java.sql.Date;

public class UsersVo implements Serializable{		// ���� ����
	private static final long serialVersionUID = 1L;
	private String id;
	private String pw;
	private String name;
	private String gender;
	private Date date;
	private int num;
	
	public UsersVo(String id, int num) {
		super();
		this.id = id;
		this.num = num;
	}

	public UsersVo(String id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	
	public UsersVo(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}
	
	public UsersVo() {
		super();
	}
	
	public UsersVo(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public UsersVo(String id, String pw, String name, String gender, Date date) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.date = date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
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
		UsersVo other = (UsersVo) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UsersVo [id=" + id + ", pw=" + pw + ", name=" + name + ", gender=" + gender + ", date=" + date
				+ ", num=" + num + "]";
	}
}
