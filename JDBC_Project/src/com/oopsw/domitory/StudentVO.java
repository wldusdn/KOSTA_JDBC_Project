package com.oopsw.domitory;

import java.util.Date;

public class StudentVO {
	private String domStudentId;
	private Date checkIn;
	private Date checkOut;
	private String note;
	private int roomNumber;
	private int studentNumber;
	private String name;
	private String major;
	private int grade;
	private int term;
	private String academicStatus;
	private Date birth;
	private String gender;
	private String phoneNumber;
	private String address;
	
	//학생 상세조회
	public StudentVO(String domStudentId, int studentNumber, String name, String major, int grade, int term, String academicStatus, Date birth, String gender,
			String phoneNumber, String address, Date checkIn, Date checkOut, String note, int roomNumber) {
		setDomStudentId(domStudentId);
		setName(name);
		setStudentNumber(studentNumber);
		setAcademicStatus(academicStatus);
		setGender(gender);
		setRoomNumber(roomNumber);
		setCheckIn(checkIn);
		setCheckOut(checkOut);
		setMajor(major);
		setGrade(grade);
		setTerm(term);
		setBirth(birth);
		setPhoneNumber(phoneNumber);
		setAddress(address);
		setNote(note);
	}
	
	//학생관리에서 조회
	public StudentVO(String domStudentId, int studentNumber, String name, String academicStatus, String gender, int roomNumber, Date checkIn, Date checkOut) {
		this(domStudentId, studentNumber, name, null, 0, 0, academicStatus,  null, gender, null, null, checkIn, checkOut, null, roomNumber);
	}
	
	//학번검색
	public StudentVO(int studentNumber, String name, String major, int grade, int term, String academicStatus,
			Date birth, String gender, String phoneNumber, String address) {
		this(null, studentNumber, name, major, grade, term, academicStatus, birth, gender, phoneNumber, address, null, null, null, 0);
	}
	
	//방배정에서 조회
	public StudentVO(String name, String major, int grade, int studentNumber, String gender){
		this(null, studentNumber, name, major, grade, 0, null, null, gender, null, null, null, null, null, 0);
	}
	
	//특정 방 거주학생 조회
	public StudentVO(String name, String major, int grade, int studentNumber){
		this(null, studentNumber, name, major, grade, 0, null, null, null, null, null, null, null, null, 0);
	}

	public String getDomStudentId() {
		return domStudentId;
	}
	public void setDomStudentId(String domStudentId) {
		this.domStudentId = domStudentId;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public String getAcademicStatus() {
		return academicStatus;
	}
	public void setAcademicStatus(String academicStatus) {
		this.academicStatus = academicStatus;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "domStudentId=" + domStudentId + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", note="
				+ note + ", roomNumber=" + roomNumber + ", studentNumber=" + studentNumber + ", name=" + name
				+ ", major=" + major + ", grade=" + grade + ", term=" + term + ", academicStatus=" + academicStatus
				+ ", birth=" + birth + ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ "\n";
	}
	
}
