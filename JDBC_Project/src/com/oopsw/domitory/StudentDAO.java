package com.oopsw.domitory;

import java.util.Collection;
import java.util.Date;

public interface StudentDAO {
	//전체학생목록확인
	Collection<StudentVO> getDomStudents();
	//특정학생목록조회
	StudentVO getDomStudent(String domStudentId);
	//특정학생수정
	boolean updateDomStudent(String domStudentId, int roomNumber, String checkIn, String checkOut, String note);
	//특정학생삭제
	boolean deleteStudent(String domStudentId);
	//학번검색
	StudentVO getStudent(int studentNumber);
	//특정학생등록
	boolean addDomStudent(String domStudentId, int studentNumber, int roomNumber, String checkIn, String checkOut, String note);
	//특정학생검색
	Collection<StudentVO> searchName(String name);
	Collection<StudentVO> searchMajor(String major);
	Collection<StudentVO> searchAcademicStatus(String academicStatus);
	Collection<StudentVO> searchRoomNumber(int roomNumber);
}
