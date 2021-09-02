package com.arri.biz.server.vo;

import java.io.Serializable;

public class HireInfoVo implements Serializable{		// ��� ����
	private static final long serialVersionUID = 1L;
	private int num;									// �� ����
	private int wage;									// �ñ�
	private String insuCheck;							// ���� ���� ����
	private String vioCheck;							// ���� ����
	private int payMoney;								// ���� ���� �ݾ�
	private int	d_day;									// �� ���� ���� �ϼ�
	private int	e_day;									// �� ���� �ָ� �ϼ�
	private int	d_time;									// �� ���� �ð� �ְ�
	private int	n_time;									// �� ���� �ð� �߰�
	private int jobNum;									// ���� id
	private String fireCheck;							// �δ� �ذ� ����(23�� 2�� / 24�� 3�� / 26�� / 27�� / 28��)
	private String disPay;								// �ӱ� �谨(����üũ / �ӻ��üũ / �ǰ����� üũ / �ӱݻ谨���� / ��� �ް� ����/ ���� ���� ����)
	private String getMoney;							// ���غ���(��翩��)
	private String docCheck;							// �ٷΰ�༭ ���ۼ� (17�� / 67�� 2�� / 67�� 3��)
	private String sal;									// �ӱ� ü�� (14�� �̳� ������ ���� / �Ұ��� ��Ȳ ���� ���� / �ӱ� ���� ���� / ���� �ް� ���� / �޾� ���� / �޾� �� �Ⱓ(�ϼ�))
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	{	
		num = 0;
		fireCheck = "N/N/N/N/N";
		disPay = "N/N/N/N/N/N";
		getMoney = "N";
		docCheck = "N/N/N";
		sal = "N/N/N/N/N/0";
	}

	public HireInfoVo() {
		super();
	}

	public HireInfoVo(String id, int num, int wage, String insuCheck, String vioCheck, int payMoney, int d_day, int e_day,
			int d_time, int n_time, int jobNum, String fireCheck, String disPay, String getMoney, String docCheck,
			String sal) {
		this.id = id;
		this.num = num;
		this.wage = wage;
		this.insuCheck = insuCheck;
		this.vioCheck = vioCheck;
		this.payMoney = payMoney;
		this.d_day = d_day;
		this.e_day = e_day;
		this.d_time = d_time;
		this.n_time = n_time;
		this.jobNum = jobNum;
		this.fireCheck = fireCheck;
		this.disPay = disPay;
		this.getMoney = getMoney;
		this.docCheck = docCheck;
		this.sal = sal;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public int getWage() {
		return wage;
	}


	public void setWage(int wage) {
		this.wage = wage;
	}


	public String getInsuCheck() {
		return insuCheck;
	}


	public void setInsuCheck(String insuCheck) {
		this.insuCheck = insuCheck;
	}


	public String getVioCheck() {
		return vioCheck;
	}


	public void setVioCheck(String vioCheck) {
		this.vioCheck = vioCheck;
	}


	public int getPayMoney() {
		return payMoney;
	}


	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}


	public int getD_day() {
		return d_day;
	}


	public void setD_day(int d_day) {
		this.d_day = d_day;
	}


	public int getE_day() {
		return e_day;
	}


	public void setE_day(int e_day) {
		this.e_day = e_day;
	}


	public int getD_time() {
		return d_time;
	}


	public void setD_time(int d_time) {
		this.d_time = d_time;
	}


	public int getN_time() {
		return n_time;
	}


	public void setN_time(int n_time) {
		this.n_time = n_time;
	}


	public int getJobNum() {
		return jobNum;
	}


	public void setJobNum(int jobNum) {
		this.jobNum = jobNum;
	}


	public String getFireCheck() {
		return fireCheck;
	}


	public void setFireCheck(String fireCheck) {
		this.fireCheck = fireCheck;
	}


	public String getDisPay() {
		return disPay;
	}


	public void setDisPay(String disPay) {
		this.disPay = disPay;
	}


	public String getGetMoney() {
		return getMoney;
	}


	public void setGetMoney(String getMoney) {
		this.getMoney = getMoney;
	}


	public String getDocCheck() {
		return docCheck;
	}


	public void setDocCheck(String docCheck) {
		this.docCheck = docCheck;
	}


	public String getSal() {
		return sal;
	}


	public void setSal(String sal) {
		this.sal = sal;
	}


	@Override
	public String toString() {
		return "HireInfoVo [num=" + num + ", wage=" + wage + ", insuCheck=" + insuCheck + ", vioCheck=" + vioCheck
				+ ", payMoney=" + payMoney + ", d_day=" + d_day + ", e_day=" + e_day + ", d_time=" + d_time
				+ ", n_time=" + n_time + ", jobNum=" + jobNum + ", fireCheck=" + fireCheck + ", disPay=" + disPay
				+ ", getMoney=" + getMoney + ", docCheck=" + docCheck + ", sal=" + sal + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + d_day;
		result = prime * result + d_time;
		result = prime * result + ((disPay == null) ? 0 : disPay.hashCode());
		result = prime * result + ((docCheck == null) ? 0 : docCheck.hashCode());
		result = prime * result + e_day;
		result = prime * result + ((fireCheck == null) ? 0 : fireCheck.hashCode());
		result = prime * result + ((getMoney == null) ? 0 : getMoney.hashCode());
		result = prime * result + ((insuCheck == null) ? 0 : insuCheck.hashCode());
		result = prime * result + jobNum;
		result = prime * result + n_time;
		result = prime * result + num;
		result = prime * result + payMoney;
		result = prime * result + ((sal == null) ? 0 : sal.hashCode());
		result = prime * result + ((vioCheck == null) ? 0 : vioCheck.hashCode());
		result = prime * result + wage;
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
		HireInfoVo other = (HireInfoVo) obj;
		if (d_day != other.d_day)
			return false;
		if (d_time != other.d_time)
			return false;
		if (disPay == null) {
			if (other.disPay != null)
				return false;
		} else if (!disPay.equals(other.disPay))
			return false;
		if (docCheck == null) {
			if (other.docCheck != null)
				return false;
		} else if (!docCheck.equals(other.docCheck))
			return false;
		if (e_day != other.e_day)
			return false;
		if (fireCheck == null) {
			if (other.fireCheck != null)
				return false;
		} else if (!fireCheck.equals(other.fireCheck))
			return false;
		if (getMoney == null) {
			if (other.getMoney != null)
				return false;
		} else if (!getMoney.equals(other.getMoney))
			return false;
		if (insuCheck == null) {
			if (other.insuCheck != null)
				return false;
		} else if (!insuCheck.equals(other.insuCheck))
			return false;
		if (jobNum != other.jobNum)
			return false;
		if (n_time != other.n_time)
			return false;
		if (num != other.num)
			return false;
		if (payMoney != other.payMoney)
			return false;
		if (sal == null) {
			if (other.sal != null)
				return false;
		} else if (!sal.equals(other.sal))
			return false;
		if (vioCheck == null) {
			if (other.vioCheck != null)
				return false;
		} else if (!vioCheck.equals(other.vioCheck))
			return false;
		if (wage != other.wage)
			return false;
		return true;
	}
	
	
	
}
