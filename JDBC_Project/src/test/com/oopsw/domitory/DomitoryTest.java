package test.com.oopsw.domitory;

import com.oopsw.domitoryImpl.ManagerDAOImpl;
import com.oopsw.domitoryImpl.RoomDAOImpl;
import com.oopsw.domitoryImpl.StudentDAOImpl;
import java.sql.SQLException;

import com.oopsw.domitory.ManagerDAO;
import com.oopsw.domitory.RoomDAO;
import com.oopsw.domitory.StudentDAO;
public class DomitoryTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		ManagerDAO m = new ManagerDAOImpl();
//		System.out.println(m.login("manager2", "asd1234#"));//로그인 검사
//		System.out.println(m.getLog("manager3")); //최종 로그 확인
//		System.out.println(m.getManagerName("manager2"));
//		RoomDAO r = new RoomDAOImpl();
//		System.out.println(r.getFloor(2));
//		System.out.println(r.getFloorType(3, 1));
//		System.out.println(r.getRoomStudent(301));
//		System.out.println(r.countRoomStudent(207));
//		System.out.println(r.searchRoomStudent(207));
//		System.out.println(r.searchNoRoomStudent("연"));
		StudentDAO s = new StudentDAOImpl();
//		System.out.println(s.getDomStudents());
//		System.out.println(s.getDomStudent("S01"));
//		System.out.println(s.getStudent(20255010));//퇴실한 학생
//		System.out.println(s.getStudent(20201253)); //이미 등록된 학생
//		System.out.println(s.addDomStudent("S012", 20201253, 307, "2025-03-01", "2026-02-20", null)); //이미 등록된 학생
//		System.out.println(s.addDomStudent("S001", 20220222, 307, "2025-03-01", "2026-02-20", null)); //기숙생코드 중복
//		System.out.println(s.addDomStudent("S101", 20220222, 307, "2025-03-01", "2026-02-20", null)); //연우진 등록
//		System.out.println(s.updateDomStudent("S101", 201, "2025-03-01", "2026-02-20", "새로 등록"));// 호실 및 비고 바꿈
//		System.out.println(s.deleteStudent("S101"));
//		System.out.println(s.searchName("차"));
//		System.out.println(s.searchMajor("컴퓨터"));
//		System.out.println(s.searchAcademicStatus("재학"));
		System.out.println(s.searchRoomNumber(311));
	}
}
