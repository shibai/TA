package com.travelapp.rest.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.travelapp.rest.beans.UserBean;
import com.travelapp.rest.dbconnection.JDBCConnection;


public class UserDAO {
	Connection conn = JDBCConnection.connectDatabase();
	Statement st = null;
	ResultSet rs = null;
	int flag;
	String query ="";
    UserBean ub = new UserBean();
	
	//create user
	public UserBean createUser(UserBean ub) throws SQLException{
		query =  "insert into user(email, firstName, lastname,password,address,"
				+ "city,state,zipcode,country,phone,type,url) values('"
				+ ub.getEmail() + "', '"
				+ ub.getFirsName() + "', '" 
				+ ub.getLastname() + "', '" 
				+ ub.getPassword() + "', '" 
				+ ub.getAddress() + "', '" 
			    + ub.getCity() + "', '" 
				+ ub.getState() + "', '" 
				+ ub.getZipcode() + "', '" 
				+ ub.getCountry() + "', '"
				+ ub.getPhone() + "', '"
				+ ub.getType() + "', '"
				+ ub.getUrl() + "')";
		 st = conn.createStatement();
		 flag = st.executeUpdate(query);
		 return ub;
	}
	
	//edit user
	public  UserBean edit(UserBean ub) throws SQLException{
		query = "update user set "
				 +"email = "+ ub.getEmail()
				 +"firstName = "+ ub.getFirsName()
				 +"lastName = "+ ub.getLastname()
				 +"password = "+ ub.getPassword()
				 +"address = "+ ub.getAddress()
				 +"zipcode = "+ ub.getZipcode()
				 +"state = "+ ub.getState()
				 +"country = "+ ub.getCountry()
				 +"phone = "+ ub.getPhone()
				 +"type = "+ ub.getType()
				 +"url = "+ ub.getUrl()
				 +"where user.id = " + ub.getId();
		 st = conn.createStatement();
		 flag = st.executeUpdate(query);
		 return ub;
		
	}	
	
	//delete user need protect
	public boolean deleteUser(String userId) throws SQLException{
		query = "delete from user where user.id  = " +  Integer.parseInt(userId);
		st = conn.createStatement();
		boolean delete = false;
		if(st.executeUpdate(query)!=0){delete = true;}	
		return delete;
	}	
	
	//accept user
	public boolean acceptUser(String userId){
		return false;
	}	
	
	//login
	public  boolean userLogin(String email,String password) throws SQLException{
		query = "select * from user where user.email= '"
				+ email + "' and user.password = '" + password + "'";
		System.out.println(query);
		st = conn.createStatement();
		boolean login = false;
		rs = st.executeQuery(query);
		if(rs.isBeforeFirst()){login = true;}
		System.out.println(rs.getRow());
		return login;	
	}	
	//sign out
	public  boolean userSignout(String email,String password){
		
		return false;
	}	
	
	//search user
	public UserBean searchUser(String userId) throws SQLException{
		
		query = "select user.id, user.email, user.firstName, user.lastName, user.address, user.city, user.state, user.zipcode, user.country"
				+ " from user"
				+ " where user.id = " + Integer.parseInt(userId);
	
			 st = conn.createStatement();
			 rs = st.executeQuery(query);
			 System.out.println(rs.getRow());
			 while (rs.next()) {
				
				ub.setId(rs.getInt("id"));
				ub.setEmail(rs.getString("email"));
				ub.setFirsName(rs.getString("firstName"));
				ub.setLastname(rs.getString("LastName"));
			 }
		
		return ub;
	}	
	
	//list all user by type
	public ArrayList<UserBean> listAllUser () throws SQLException {
		
		query = "select user.id, user.email, user.firstName, user.lastName, user.address, user.city, user.state, user.zipcode, user.country from user";
				
		ArrayList<UserBean> users = new ArrayList<UserBean>();
	
			st = conn.createStatement();
			rs = st.executeQuery(query);
			System.out.println(rs.getRow());
			while (rs.next()) {
				//ub.setId(rs.getInt("id"));
				ub.setEmail(rs.getString("email"));
				ub.setFirsName(rs.getString("firstName"));
				ub.setLastname(rs.getString("LastName"));
				ub.setFirsName(rs.getString("firstName"));
				ub.setLastname(rs.getString("zipcode"));
				ub.setFirsName(rs.getString("city"));
				ub.setLastname(rs.getString("state"));
				ub.setFirsName(rs.getString("country"));
				users.add(ub);
			}
		return users;
	}

}
