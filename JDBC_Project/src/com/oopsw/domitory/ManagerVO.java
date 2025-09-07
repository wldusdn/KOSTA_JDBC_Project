package com.oopsw.domitory;

import java.util.Date;

public class ManagerVO {
	private String loginIp;
	private Date loginDateTime;
	
	public ManagerVO(String loginIp, Date loginDateTime, String name) {
		setLoginIp(loginIp);
		setLoginDateTime(loginDateTime);
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Date getLoginDateTime() {
		return loginDateTime;
	}
	public void setLoginDateTime(Date loginDateTime) {
		this.loginDateTime = loginDateTime;
	}
	
}
