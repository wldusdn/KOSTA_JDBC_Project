package test.com.oopsw.domitory;

import com.oopsw.domitoryImpl.ManagerDAOImpl;
import com.oopsw.domitoryImpl.RoomDAOImpl;
import java.sql.SQLException;

import com.oopsw.domitory.ManagerDAO;
import com.oopsw.domitory.RoomDAO;
public class DomitoryTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		ManagerDAO m = new ManagerDAOImpl();
//		System.out.println(m.login("manager2", "asd1234#"));//로그인 검사
//		System.out.println(m.getLog("manager3")); //최종 로그 확인
//		System.out.println(m.getManagerName("manager2"));
		RoomDAO r = new RoomDAOImpl();
//		System.out.println(r.getFloor(2));
//		System.out.println(r.getFloorType(3, 1));
//		System.out.println(r.getRoomStudent(301));
//		System.out.println(r.countRoomStudent(207));
//		System.out.println(r.searchRoomStudent(207));
		System.out.println(r.searchNoRoomStudent("연"));
	}
}
