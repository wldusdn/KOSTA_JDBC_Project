package com.oopsw.domitory;

import java.util.Collection;

public interface RoomDAO {
	//호실조회
	Collection<RoomVO> getFloor(int floor);
	int getFloorType(int floor, int type);
	Collection<String> getRoomStudent(int roomNumber);
	
	//특정호실정보조회
	Collection<StudentVO> searchRoomStudent(int roomNumber);
	int countRoomStudent(int roomNumber);
	
	//호실배정
	Collection<StudentVO> searchNoRoomStudent(String name);
	
}
