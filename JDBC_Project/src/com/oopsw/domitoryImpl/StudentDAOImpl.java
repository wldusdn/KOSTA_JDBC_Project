package com.oopsw.domitoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.oopsw.domitory.RoomVO;
import com.oopsw.domitory.StudentDAO;
import com.oopsw.domitory.StudentVO;

public class StudentDAOImpl implements StudentDAO{
	private Connection conn;
	
	public StudentDAOImpl() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String uri = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String id = "hr";
		String pw = "hr";
		conn = DriverManager.getConnection(uri,id,pw);
	}

	@Override
	public Collection<StudentVO> getDomStudents() {
		String sql = "select d.dom_student_id, s.name, s.student_number, s.academic_status, s.gender, d.room_number, d.check_in, d.expected_check_out from dom_student d, student s where s.student_number = d.student_number and d.expected_check_out >= sysdate";
		Collection list = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<StudentVO>();
			while(rs.next()) list.add(new StudentVO(rs.getString(1), rs.getInt(3), rs.getString(2), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getDate(8)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public StudentVO getDomStudent(String domStudentId) {
		String sql = "select s.student_number, s.name, s.major, s.grade, s.term, s.academic_status, s.birth, s.gender, s.phone_number, s.address, d.check_in, d.expected_check_out, d.note, d.room_number from dom_student d, student s where s.student_number = d.student_number and d.dom_student_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, domStudentId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) return new StudentVO(domStudentId, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDate(12), rs.getString(13), rs.getInt(14));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateDomStudent(String domStudentId, int roomNumber, String checkIn, String checkOut, String note) {
		String sql = "update dom_student set room_number = ?, check_in = ?, expected_check_out = ?, note = ? where dom_student_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNumber);
			pstmt.setDate(2, java.sql.Date.valueOf(checkIn));
			pstmt.setDate(3, java.sql.Date.valueOf(checkOut));
			pstmt.setString(4, note);
			pstmt.setString(5, domStudentId);
			int i = pstmt.executeUpdate();
			return i == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteDomStudent(String domStudentId) {
		String sql = "delete from dom_student where dom_student_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, domStudentId);
			int i = pstmt.executeUpdate();
			return i == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public StudentVO getStudent(int studentNumber) {
		String sql = "select name, major, grade, term, academic_status, birth, gender, phone_number, address from student where student_number not in (select student_number from dom_student where expected_check_out >= sysdate) and student_number = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentNumber);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) return new StudentVO(studentNumber, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addDomStudent(String domStudentId, int studentNumber, int roomNumber, String checkIn, String checkOut,
			String note) {
		String sql = "insert into dom_student (dom_student_id, student_number, room_number, check_in, expected_check_out, note) values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, domStudentId);
			pstmt.setInt(2, studentNumber);
			pstmt.setInt(3, roomNumber);
			pstmt.setDate(4, java.sql.Date.valueOf(checkIn));
			pstmt.setDate(5, java.sql.Date.valueOf(checkOut));
			pstmt.setString(6, note);
			int i = pstmt.executeUpdate();
			return i == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Collection<StudentVO> searchName(String name) {
		String sql = "select d.dom_student_id, s.name, s.student_number, s.academic_status, s.gender, d.room_number, d.check_in, d.expected_check_out from dom_student d, student s where s.student_number = d.student_number and s.name like '%' || ? || '%' and d.expected_check_out >= sysdate";
		Collection list = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<StudentVO>();
			while(rs.next()) list.add(new StudentVO(rs.getString(1), rs.getInt(3), rs.getString(2), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getDate(8)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Collection<StudentVO> searchMajor(String major) {
		String sql = "select d.dom_student_id, s.name, s.student_number, s.academic_status, s.gender, d.room_number, d.check_in, d.expected_check_out from dom_student d, student s where s.student_number = d.student_number and s.major like '%' || ? || '%' and d.expected_check_out >= sysdate";
		Collection list = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, major);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<StudentVO>();
			while(rs.next()) list.add(new StudentVO(rs.getString(1), rs.getInt(3), rs.getString(2), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getDate(8)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Collection<StudentVO> searchAcademicStatus(String academicStatus) {
		String sql = "select d.dom_student_id, s.name, s.student_number, s.gender, d.room_number, d.check_in, d.expected_check_out from dom_student d, student s where s.student_number = d.student_number and s.academic_status = ? and d.expected_check_out >= sysdate";
		Collection list = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, academicStatus);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<StudentVO>();
			while(rs.next()) list.add(new StudentVO(rs.getString(1), rs.getInt(3), rs.getString(2), academicStatus, rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getDate(7)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Collection<StudentVO> searchRoomNumber(int roomNumber) {
		String sql = "select d.dom_student_id, s.name, s.student_number, s.academic_status, s.gender, d.check_in, d.expected_check_out from dom_student d, student s where s.student_number = d.student_number and d.room_number = ? and d.expected_check_out >= sysdate";
		Collection list = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNumber);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<StudentVO>();
			while(rs.next()) list.add(new StudentVO(rs.getString(1), rs.getInt(3), rs.getString(2), rs.getString(4), rs.getString(5), roomNumber, rs.getDate(6), rs.getDate(7)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
