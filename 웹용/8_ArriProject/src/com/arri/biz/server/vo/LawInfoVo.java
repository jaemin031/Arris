package com.arri.biz.server.vo;

import java.io.Serializable;

public class LawInfoVo implements Serializable{		// ���� ����
	private static final long serialVersionUID = 1L;
	private String article;
	private String explain;
	private int fine;
	private String penalty;
	private int lc_number;
	
	public LawInfoVo() {
		super();
	}
	public LawInfoVo(String article, String explain, int fine, String penalty, int lc_number) {
		super();
		this.article = article;
		this.explain = explain;
		this.fine = fine;
		this.penalty = penalty;
		this.lc_number = lc_number;
	}
	
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public String getPenalty() {
		return penalty;
	}
	public void setPenalty(String penalty) {
		this.penalty = penalty;
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
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((explain == null) ? 0 : explain.hashCode());
		result = prime * result + fine;
		result = prime * result + lc_number;
		result = prime * result + ((penalty == null) ? 0 : penalty.hashCode());
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
		LawInfoVo other = (LawInfoVo) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (explain == null) {
			if (other.explain != null)
				return false;
		} else if (!explain.equals(other.explain))
			return false;
		if (fine != other.fine)
			return false;
		if (lc_number != other.lc_number)
			return false;
		if (penalty == null) {
			if (other.penalty != null)
				return false;
		} else if (!penalty.equals(other.penalty))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "LawInfoVo [article=" + article + ", explain=" + explain + ", fine=" + fine + ", penalty=" + penalty
				+ ", lc_number=" + lc_number + "]";
	}
}
