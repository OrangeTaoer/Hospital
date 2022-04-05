package com.zzt.entity.build;

import java.util.List;

public class BuildFloor {
	private String name;
	private String explain;
	private List<Room> rooms;

	private static BuildFloor buildFloor = new BuildFloor();
	
	public static BuildFloor getBuildFloor()
	{
		return buildFloor;
	}
	
	private BuildFloor() {
	}

	public BuildFloor(String name, String explain, List<Room> rooms) {
		super();
		this.name = name;
		this.explain = explain;
		this.rooms = rooms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}
