package com.zzt.entity.build;

import java.util.List;

public class Building {

	private List<BuildFloor> buildFloors;
	private String name;
	private String explain;

	private static Building building = new Building();

	public static Building getBuilding() {
		return building;
	}

	private Building() {
	}

	public Building(List<BuildFloor> buildFloors, String name, String explain) {
		super();
		this.buildFloors = buildFloors;
		this.name = name;
		this.explain = explain;
	}

	public List<BuildFloor> getBuildFloors() {
		return buildFloors;
	}

	public void setBuildFloors(List<BuildFloor> buildFloors) {
		this.buildFloors = buildFloors;
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

}
