package com.arri.biz.server.vo;

import java.io.Serializable;

public class JobsVo implements Serializable{		// ����
	private static final long serialVersionUID = 1L;
	private int jobNum;
	private String jobsPort;
	private String jobPart;
	
	public JobsVo() {
		super();
	}
	public JobsVo(int jobNum, String jobsPort, String jobPart) {
		super();
		this.jobNum = jobNum;
		this.jobsPort = jobsPort;
		this.jobPart = jobPart;
	}
	
	public int getJobNum() {
		return jobNum;
	}
	public void setJobNum(int jobNum) {
		this.jobNum = jobNum;
	}
	public String getJobsPort() {
		return jobsPort;
	}
	public void setJobsPort(String jobsPort) {
		this.jobsPort = jobsPort;
	}
	public String getJobPart() {
		return jobPart;
	}
	public void setJobPart(String jobPart) {
		this.jobPart = jobPart;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + jobNum;
		result = prime * result + ((jobPart == null) ? 0 : jobPart.hashCode());
		result = prime * result + ((jobsPort == null) ? 0 : jobsPort.hashCode());
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
		JobsVo other = (JobsVo) obj;
		if (jobNum != other.jobNum)
			return false;
		if (jobPart == null) {
			if (other.jobPart != null)
				return false;
		} else if (!jobPart.equals(other.jobPart))
			return false;
		if (jobsPort == null) {
			if (other.jobsPort != null)
				return false;
		} else if (!jobsPort.equals(other.jobsPort))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "JobsVo [jobNum=" + jobNum + ", jobsPort=" + jobsPort + ", jobPart=" + jobPart + "]";
	}
}
