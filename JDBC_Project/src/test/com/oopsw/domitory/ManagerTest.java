package test.com.oopsw.domitory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.oopsw.domitory.ManagerDAO;
import com.oopsw.domitoryImpl.ManagerDAOImpl;

public class ManagerTest {
static ManagerDAO m;

@BeforeClass
public static void setUpBeforeClass() throws Exception {
m = new ManagerDAOImpl();
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
public void logintest() {
assertTrue(m.login("manager2", "asd1234#"));
}

@Test
public void loginFailTest() {
assertFalse(m.login("manager2", "asdfasdf"));
}

@Test
public void addLogTest(){
assertTrue(m.addLog("manager2"));
}

@Test
public void addLogFailTest(){
assertFalse(m.addLog("manager4"));
}

@Test
public void getLogTest(){
assertNotNull(m.getLog("manager2"));
}

@Test
public void getLogFailTest(){
assertNull(m.getLog("manager4"));
}

@Test
public void getManagerNameTest(){
assertEquals("신라면", m.getManagerName("manager2"));
}

@Test
public void getManagerNameFailTest(){
assertNotEquals("진라면", m.getManagerName("manager2"));
}

}