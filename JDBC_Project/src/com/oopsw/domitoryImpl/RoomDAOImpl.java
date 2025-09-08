package com.oopsw.domitoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.oopsw.domitory.RoomDAO;
import com.oopsw.domitory.RoomVO;
import com.oopsw.domitory.StudentVO;

public class RoomDAOImpl implements RoomDAO{
	private Connection conn;
	public RoomDAOImpl() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String uri = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String id = "hr";
		String pw = "hr";
		conn = DriverManager.getConnection(uri,id,pw);
	}
	
	@Override
	public Collection<RoomVO> getFloor(int floor) {
		String sql = "select room_number, room_type from room where floor = ?";
		Collection list = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, floor);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<RoomVO>();
			while(rs.next()) list.add(new RoomVO(rs.getInt(1), floor, rs.getInt(2)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Collection<Integer> getFloorType(int floor, int type) {
		String sql = "select room_number from room where floor = ? and room_type = ?";
		Collection list = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, floor);
			pstmt.setInt(2, type);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<RoomVO>();
			while(rs.next()) list.add(new RoomVO(rs.getInt(1),floor, type));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Collection<String> getRoomStudent(int roomNumber) {
		String sql = "select name from student where student_number in (select student_number from dom_student where room_number = ? and expected_check_out >= sysdate)";
		Collection list = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNumber);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<String>();
			while(rs.next()) list.add(rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Collection<StudentVO> searchRoomStudent(int roomNumber) {
		String sql = "select s.name, s.major, s.grade, s.student_number from student s, dom_student d where room_number = ? and s.student_number = d.student_number and d.expected_check_out >= sysdate";
		Collection list = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNumber);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<StudentVO>();
			while(rs.next()) list.add(new StudentVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int countRoomStudent(int roomNumber) {
		String sql = "select count(dom_student_id) from dom_student where room_number = ? and expected_check_out >= sysdate";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNumber);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	@Override
	public Collection<StudentVO> searchNoRoomStudent(String name) {
		String sql = "select name, major, grade, student_number, gender from student where student_number not in (select student_number from dom_student where expected_check_out >= sysdate) and name like '%' || ? || '%'";
		Collection list = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<StudentVO>();
			while(rs.next()) list.add(new StudentVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
