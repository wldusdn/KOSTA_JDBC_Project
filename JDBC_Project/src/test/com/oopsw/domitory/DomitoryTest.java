package test.com.oopsw.domitory;

import com.oopsw.domitoryImpl.ManagerDAOImpl;

import java.sql.SQLException;

import com.oopsw.domitory.ManagerDAO;

public class DomitoryTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ManagerDAO m = new ManagerDAOImpl();
//		System.out.println(m.login("manager2", "asd1234#"));//로그인 검사
//		System.out.println(m.getLog("manager3")); //최종 로그 확인
//		System.out.println(m.getManagerName("manager2"));
	}
}
