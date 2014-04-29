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
	String query ="";
	UserBean ub = new UserBean();
	
	//create user
	public void createUser(String email,String firstName,String lastName,String password,String address,String city, String zipcode,String state,String country,String phone,String type) throws SQLException{
		query =  "insert into user(email, firstName, lastname,password,address,"
				+ "city,state,zipcode,country,phone,type) values('"
				+ email + "', '"
				+ firstName + "', '" 
				+ lastName + "', '" 
				+ password + "', '" 
				+ address + "', '" 
			    + city + "', '" 
				+ state  + "', '" 
				+ zipcode + "', '" 
				+ country + "', '"
				+ phone + "', '"
				+ type + "')";
		 st = conn.createStatement();
		 rs = st.executeQuery(query);
		
	}
	
	//edit user
	public void edit(UserBean user, String email,String firstName,String lastName, String password,String address,String city, String zipcode,String state,String country,String phone) throws SQLException{
		if(email.equals("")){email = user.getEmail();}
		if(password.equals("")){password = user.getPassword();}
		if(address.equals("")){address = user.getAddress();}
		if(zipcode.equals("")){zipcode= user.getZipcode();}
		if(state.equals("")){state = user.getState();}
		if(country.equals("")){country = user.getCountry();}
	    if(phone.equals("")){phone = user.getPhone();}
		query = "update user set "
				 +"email = "+ email
				 +"firstName = "+ email
				 +"lastName = "+ email
				 +"password = "+ password
				 +"address = "+ address
				 +"zipcode = "+ zipcode
				 +"state = "+ state
				 +"country = "+ country
				 +"phone = "+ phone
				 +"where user.id = " + user.getId();
		 st = conn.createStatement();
		 rs = st.executeQuery(query);
		
	}	
	
	//delete user need protect
	public void deleteUser(String userId) throws SQLException{
		query = "delete from user where user.id  = " +  Integer.parseInt(userId);
		st = conn.createStatement();
		rs = st.executeQuery(query);	
	}	
	
	//accept user
	public boolean acceptUser(String userId){
		return false;
	}	
	
	//login
	public  boolean userLogin(String email,String password) throws SQLException{
		query = "select email and password from user where user.email="
				+email + "and user.password =" + password;
		st = conn.createStatement();
		return st.execute(query);	
	}	
	//sign out
	public  boolean userSignout(String email,String password){
		
		return false;
	}	
	
	//search user
	public UserBean searchUser(String userId) throws SQLException{
		
		query = "select user.id, user.email, user.firstName, user.lastName, user.address, user.city, user.state, user.zipcode, user.country"
				+ "from user"
				+ " where user.id = " + Integer.parseInt(userId);
		
			 st = conn.createStatement();
			 rs = st.executeQuery(query);
			
			 while (rs.next()) {
				
				ub.setId(rs.getInt("id"));
				ub.setEmail(rs.getString("email"));
				ub.setFirsName(rs.getString("firstName"));
				ub.setLastname(rs.getString("LasttName"));
			 }
		
		return ub;
	}	
	
	//list all user by type
	public ArrayList<UserBean> listAllUser () throws SQLException {
		
		query = "select user.id, user.email, user.firstName, user.lastName, user.address, user.city, user.state, user.zipcode, user.country"
				+ "from user";
				
		ArrayList<UserBean> users = new ArrayList<UserBean>();
	
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next()) {
				//ub.setId(rs.getInt("id"));
				ub.setEmail(rs.getString("email"));
				ub.setFirsName(rs.getString("firstName"));
				ub.setLastname(rs.getString("LasttName"));
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
