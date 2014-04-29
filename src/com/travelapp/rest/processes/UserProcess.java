package com.travelapp.rest.processes;
import java.sql.SQLException;
import java.util.ArrayList;

import com.travelapp.rest.beans.UserBean;
import com.travelapp.rest.daos.UserDAO;


public class UserProcess {
	//Connection conn = JDBCConnection.connectDatabase();
	UserDAO ub = new UserDAO();
	public void createUser(String email,String firstName,String lastName,String password,String address,String city, String zipcode,String state,String country,String phone,String type) throws SQLException{
		ub.createUser(email, firstName, lastName, password, address, city, zipcode, state, country,phone,type);
	}
	public void editUser(UserBean user, String email,String firstName,String lastName, String password,String address,String city, String zipcode,String state,String country,String phone,String type) throws SQLException{
		ub.edit(user, email, firstName, lastName, password, address, city, zipcode, state, country,phone);
	}	
	public void deleteUser(String userId) throws SQLException{
		ub.deleteUser(userId);
	}	
	public boolean acceptUser(String userId){
		return false;
	}	
	public void userLogin(String email,String password) throws SQLException{
		ub.userLogin(email, password);
	}	
	public void userSignout(String email,String password){
		
	}	
	
	public UserBean searchUser(String userId) throws SQLException{
		
		return ub.searchUser(userId);
	}	
	
	public ArrayList<UserBean> listAllUsers() throws SQLException{
		return ub.listAllUser();
	}
}
