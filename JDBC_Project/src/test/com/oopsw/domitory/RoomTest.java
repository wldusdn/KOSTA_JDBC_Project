package test.com.oopsw.domitory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.oopsw.domitory.RoomDAO;
import com.oopsw.domitoryImpl.RoomDAOImpl;

public class RoomTest {
	static RoomDAO r;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		r = new RoomDAOImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getFloorTest() {
		assertNotNull(r.getFloor(2));
	}
	
	@Test
	public void getFloorFailTest() {
		assertEquals(0, r.getFloor(1).size());
	}
	
	@Test
	public void getFloorTypeTest() {
		assertNotNull(r.getFloorType(3, 1));
	}
	
	@Test
	public void getFloorTypeFailTest() {
		assertEquals(0, r.getFloorType(1, 1).size());
	}
	
	@Test
	public void getRoomStudentTest() {
		assertNotNull(r.getRoomStudent(301));
	}
	
//	@Test
	public void getRoomStudentFailTest() { //get 실패테스트는 어케하는지..?
		assertEquals(0, r.getRoomStudent(106).size()); //0이 나온다고 실패가 아닌데..
	}
	
	@Test
	public void countRoomStudentTest() {
		assertEquals(1, r.countRoomStudent(207));
	}
	
	@Test
	public void searchRoomStudentTest() {
		assertNotNull(r.searchRoomStudent(207));
	}
	
	@Test
	public void searchNoRoomStudentTest() {
		assertNotNull(r.searchNoRoomStudent("연"));
	}

	
}
