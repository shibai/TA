package com.travelapp.rest.processes;
import java.sql.SQLException;
import java.util.ArrayList;

import com.travelapp.rest.beans.GroupBean;
import com.travelapp.rest.beans.UserBean;
import com.travelapp.rest.daos.UserDAO;


public class UserProcess {
	//Connection conn = JDBCConnection.connectDatabase();
	UserDAO ud = new UserDAO();
	
	public UserBean createUser(String email,String firstName,String lastName,String password,String address,String city, String zipcode,String state,String country,String phone,String type,String url) throws SQLException{
		UserBean ub = new UserBean();
		ub.setEmail(email);
		ub.setFirsName(firstName);
		ub.setLastname(lastName);
		ub.setPassword(password);
		ub.setAddress(address);
		ub.setCity(city);
		ub.setZipcode(zipcode);
		ub.setState(state);
		ub.setCountry(country);
		ub.setType(type);
		ub.setUrl(url);
		ub =ud.createUser(ub);
		return ub;
	}
	public UserBean editUser(String email,String firstName,String lastName, String password,String address,String city, String zipcode,String state,String country,String phone,String type,String url) throws SQLException{
		UserBean ub = new UserBean();
		ub.setEmail(email);
		ub.setFirsName(firstName);
		ub.setLastname(lastName);
		ub.setPassword(password);
		ub.setAddress(address);
		ub.setCity(city);
		ub.setZipcode(zipcode);
		ub.setState(state);
		ub.setCountry(country);
		ub.setType(type);
		ub.setUrl(url);
		ub =ud.edit(ub);
		return ub;
	}	
	public boolean deleteUser(String userId) throws SQLException{
		
		return ud.deleteUser(userId);
	}	
	public boolean acceptUser(String userId){
		return false;
	}	
	public boolean userLogin(String email,String password) throws SQLException{
		return ud.userLogin(email, password);
	}	
	public void userSignout(String email,String password){
		
	}	
	
	public UserBean searchUser(String userId) throws SQLException{
		
		return ud.searchUser(userId);
	}	
	
	public ArrayList<UserBean> listAllUsers() throws SQLException{
		
		return ud.listAllUser();
	}
}
