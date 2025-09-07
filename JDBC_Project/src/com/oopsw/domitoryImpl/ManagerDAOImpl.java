package com.oopsw.domitoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oopsw.domitory.ManagerDAO;
import com.oopsw.domitory.ManagerVO;

public class ManagerDAOImpl implements ManagerDAO{
	private Connection conn;
	
	public ManagerDAOImpl() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String uri = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String id = "hr";
		String pw = "hr";
		conn = DriverManager.getConnection(uri,id,pw);
	}
	
	@Override
	public boolean login(String id, String pw) {
		String sql = "select manager_id, password from manager where manager_id = ? and password = ?";
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) result = addLog(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean addLog(String id) {
		String sql = "insert into manager_log (login_number, manager_id, login_ip, login_date_time) values (login_number.nextval, ?, '211.108.000.000', sysdate)";
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int i = pstmt.executeUpdate();
			if(i == 1) result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ManagerVO getLog(String id) {
		String sql = "select login_ip, login_date_time from manager_log where login_number = (select max(login_number) from manager_log where manager_id = ?)";
		ManagerVO m = new ManagerVO();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) m = new ManagerVO(rs.getString(1), rs.getDate(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public String getManagerName(String id) {
		String sql = "select name from manager where manager_id = ?";
		String result = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
