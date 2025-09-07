package com.oopsw.domitory;

public interface ManagerDAO {
	//관리자 로그인
	boolean login(String id, String pw);
	boolean addLog(String id);
	
	//사이드 바
	ManagerVO getLog(String id);
	String getManagerName(String id);
}
