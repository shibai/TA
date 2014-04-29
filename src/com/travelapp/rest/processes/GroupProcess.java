package com.travelapp.rest.processes;


import java.sql.Connection;

import com.travelapp.rest.beans.GroupBean;
import com.travelapp.rest.beans.UserBean;
import com.travelapp.rest.daos.GroupDAO;
import com.travelapp.rest.dbconnection.JDBCConnection;

public class GroupProcess {
	
	GroupDAO groupDAO = new GroupDAO();
	
	public GroupBean viewGroup (String groupId) {
		Connection conn = JDBCConnection.connectDatabase();
		int id = Integer.parseInt(groupId);
		GroupBean groupBean = groupDAO.viewGroup(id, conn);
		
		return groupBean;
	}

	public UserBean[] viewMembers (String groupId) {
		Connection conn = JDBCConnection.connectDatabase();
		int id = Integer.parseInt(groupId);
		UserBean[] userBean = groupDAO.viewMembers(id,conn);
		
		return userBean;
	}

	public GroupBean createGroup (String userId, String name, String type, String country, String city, String state, String content) {
		Connection conn = JDBCConnection.connectDatabase();
		int id = Integer.parseInt(userId);
		GroupBean gb = new GroupBean();
		gb.setName(name);
		gb.setCity(city);
		gb.setUserId(id);
		gb.setState(state);
		gb.setCountry(country);
		gb.setContent(content);
		gb.setType(type);
		
		gb = groupDAO.createGroup(gb,conn);
		return gb;
	}
	
	public String addUser (String groupId, String userId) {
		Connection conn = JDBCConnection.connectDatabase();
		int uid = Integer.parseInt(userId); 
		int gid = Integer.parseInt(groupId);
		String flag;

		if (groupDAO.addUser(uid, gid,conn)) {
			flag = "true";
		}else {
			flag = "false";
		}
		
		return flag;
	}
	
	public GroupBean editGroup (String groupId, String userId, String name, String type, String country, String city, String state, String content) {
		Connection conn = JDBCConnection.connectDatabase();
		int gid = Integer.parseInt(groupId);
		int uid = Integer.parseInt(userId);
		GroupBean gb = new GroupBean();
		gb.setId(gid);
		gb.setUserId(uid);
		gb.setType(type);
		gb.setName(name);
		gb.setCity(city);
		gb.setUserId(uid);
		gb.setState(state);
		gb.setCountry(country);
		gb.setContent(content);
		
		gb = groupDAO.editGroup(gb,conn);
		return gb;
	}
	
	public String removeUser (String groupId, String userId) {
		Connection conn = JDBCConnection.connectDatabase();
		int uid = Integer.parseInt(userId); 
		int gid = Integer.parseInt(groupId);
		String flag;

		if (groupDAO.removeUser(uid, gid,conn)) {
			flag = "true";
		}else {
			flag = "false";
		}
		
		return flag;
	} 
	
	public String deleteGroup (String groupId) {
		Connection conn = JDBCConnection.connectDatabase();
		int gid = Integer.parseInt(groupId);
		String flag;

		if (groupDAO.deleteGroup(gid,conn)) {
			flag = "true";
		}else {
			flag = "false";
		}
		
		return flag; 
	}
}
