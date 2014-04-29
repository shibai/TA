package com.travelapp.rest.beans;
/*
 * Bean class for group - user relationship
 */
public class GroupUserBean {
	private int id;
	private int groupId;
	private int userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
