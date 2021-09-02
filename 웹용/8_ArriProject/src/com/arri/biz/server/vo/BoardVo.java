package com.arri.biz.server.vo;

import java.io.Serializable;
import java.sql.Date;

public class BoardVo implements Serializable{
	private static final long serialVersionUID = 1L;
    private int seq = 0;
    private String title;
    private String writer;
    private String coment;
    private Date regdate;
    private int cnt;
    private String userid;
    private String part;
	
    public BoardVo() {
		super();
	}

	public BoardVo(int seq, String title, String writer, String coment, Date regdate, int cnt, String userid,
			String part) {
		super();
		this.seq = seq;
		this.title = title;
		this.writer = writer;
		this.coment = coment;
		this.regdate = regdate;
		this.cnt = cnt;
		this.userid = userid;
		this.part = part;
	}

	public BoardVo(String title, String writer, String coment, Date regdate, int cnt, String userid, String part) {
		super();
		this.title = title;
		this.writer = writer;
		this.coment = coment;
		this.regdate = regdate;
		this.cnt = cnt;
		this.userid = userid;
		this.part = part;
	}

	public BoardVo(int seq, String title, String writer, String coment, Date regdate, int cnt, String part) {
		super();
		this.seq = seq;
		this.title = title;
		this.writer = writer;
		this.coment = coment;
		this.regdate = regdate;
		this.cnt = cnt;
		this.part = part;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cnt;
		result = prime * result + ((coment == null) ? 0 : coment.hashCode());
		result = prime * result + ((part == null) ? 0 : part.hashCode());
		result = prime * result + ((regdate == null) ? 0 : regdate.hashCode());
		result = prime * result + seq;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
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
		BoardVo other = (BoardVo) obj;
		if (cnt != other.cnt)
			return false;
		if (coment == null) {
			if (other.coment != null)
				return false;
		} else if (!coment.equals(other.coment))
			return false;
		if (part == null) {
			if (other.part != null)
				return false;
		} else if (!part.equals(other.part))
			return false;
		if (regdate == null) {
			if (other.regdate != null)
				return false;
		} else if (!regdate.equals(other.regdate))
			return false;
		if (seq != other.seq)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoardVo [seq=" + seq + ", title=" + title + ", writer=" + writer + ", coment=" + coment + ", regdate="
				+ regdate + ", cnt=" + cnt + ", userid=" + userid + ", part=" + part + "]";
	}
    
    

}
