package com.travelapp.rest.beans;
/*
 * Bean class for flight passenger
 */
public class FlightPassengerBean {
	private int id;
	private int bookingId;
	private String firstName;
	private String lastName;
	private String driverLicence;
	private String passport;
	private float price;
	private String seatNum;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDriverLicence() {
		return driverLicence;
	}
	public void setDriverLicence(String driverLicence) {
		this.driverLicence = driverLicence;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}


}
