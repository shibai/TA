package com.travelapp.rest.beans;
/*
 *  Bean class for flight tickets
 */

public class FlightBookingBean {
	private int id;
	private int userId;
	private int agencyId;
	private int airlineId;
	private String flightNum;
	private String from;
	private String to;
	private int numOfGuest;
	private float totalPrice;
	private String time;
	private Boolean confirm;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	public int getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getNumOfGuest() {
		return numOfGuest;
	}
	public void setNumOfGuest(int numOfGuest) {
		this.numOfGuest = numOfGuest;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Boolean getConfirm() {
		return confirm;
	}
	public void setConfirm(Boolean confirm) {
		this.confirm = confirm;
	}

}
