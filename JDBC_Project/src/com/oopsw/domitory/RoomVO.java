package com.oopsw.domitory;

public class RoomVO {
	private int roomNumber;
	private int floor;
	private int roomType;
	
	public RoomVO(int roomNumber, int floor, int roomType) {
		setRoomNumber(roomNumber);
		setFloor(floor);
		setRoomType(roomType);
	}
	//이거 필요없을 듯?
//	public RoomVO(int roomNumber, int roomType){
//		this(roomNumber, 0, roomType);
//	}
	
	
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getRoomType() {
		return roomType;
	}
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "roomNumber=" + roomNumber + ", floor=" + floor + ", roomType=" + roomType + "\n";
	}
	
}
