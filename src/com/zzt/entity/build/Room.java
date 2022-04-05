package com.zzt.entity.build;

import java.util.List;

public class Room {
	private String name;
	private String maxHold;
	private String vaildHold;
	private String explain;
	private String position;
	private List<Bed> beds;
	private boolean special;
	private String continueTime;
	private String endtime;
	private String specialType;

	
	private static Room room = new Room();
	
	public static Room getRoom()
	{
		return room;
	}
	
	private Room() {

	}
	
	

	public Room(String name, String maxHold, String vaildHold, String explain,
			String position, List<Bed> beds, boolean special,
			String continueTime, String endtime, String specialType) {
		super();
		this.name = name;
		this.maxHold = maxHold;
		this.vaildHold = vaildHold;
		this.explain = explain;
		this.position = position;
		this.beds = beds;
		this.special = special;
		this.continueTime = continueTime;
		this.endtime = endtime;
		this.specialType = specialType;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaxHold() {
		return maxHold;
	}

	public void setMaxHold(String maxHold) {
		this.maxHold = maxHold;
	}

	public String getVaildHold() {
		return vaildHold;
	}

	public void setVaildHold(String vaildHold) {
		this.vaildHold = vaildHold;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List<Bed> getBeds() {
		return beds;
	}

	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}

	public boolean isSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public String getContinueTime() {
		return continueTime;
	}

	public void setContinueTime(String continueTime) {
		this.continueTime = continueTime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getSpecialType() {
		return specialType;
	}

	public void setSpecialType(String specialType) {
		this.specialType = specialType;
	}
	

}
