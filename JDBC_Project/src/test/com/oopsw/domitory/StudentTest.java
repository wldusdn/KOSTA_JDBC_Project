package test.com.oopsw.domitory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.oopsw.domitory.StudentDAO;
import com.oopsw.domitoryImpl.StudentDAOImpl;

public class StudentTest {
	static StudentDAO s;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		s = new StudentDAOImpl();
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
	public void getDomStudentsTest() {
		assertNotNull(s.getDomStudents());
	}
	
	@Test
	public void getDomStudentTest() {
		assertNotNull(s.getDomStudent("S001"));
	}
	
	@Test
	public void getDomStudentFailTest() {
		assertNull(s.getDomStudent("S000"));
	}
	
	@Test
	public void getStudentTest() {
		assertNotNull(s.getStudent(20255010));
	}
	
	@Test
	public void getStudentFailTest() {
		assertNull(s.getStudent(20201253));
	}
	
	@Test
	public void updateDomStudentTest() {
		assertTrue(s.updateDomStudent("S101", 201, "2025-03-01", "2026-02-20", "새로 등록"));
	}
	
	@Test
	public void updateDomStudentFailTest() {
		assertFalse(s.updateDomStudent("S100", 201, "2025-03-01", "2026-02-20", "새로 등록"));
	}
	
	@Test
	public void deleteDomStudentTest() {
		assertTrue(s.deleteDomStudent("S102"));
	}
	
	@Test
	public void deleteDomStudentFailTest() {
		assertFalse(s.deleteDomStudent("S100"));
	}
	
	@Test
	public void addDomStudentTest() {
		assertTrue(s.addDomStudent("S101", 20220222, 307, "2025-03-01", "2026-02-20", null));
	}
	
	@Test
	public void addDomStudentFailTest() {
		assertFalse(s.addDomStudent("S012", 20201253, 307, "2025-03-01", "2026-02-20", null));
		assertFalse(s.addDomStudent("S001", 20220222, 307, "2025-03-01", "2026-02-20", null));
	}
	
	@Test 
	public void searchStudentTest() { //검색메서드는 어떻게 테스트하는지? 실패하는 경우가 뭐가 있지..?
		assertNotNull(s.searchName("차"));
		assertNotNull(s.searchMajor("컴퓨터"));
		assertNotNull(s.searchAcademicStatus("재학"));
		assertNotNull(s.searchRoomNumber(311));
		
	}
	
}
