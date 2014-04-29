package com.travelapp.rest.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.travelapp.rest.beans.TripBean;
import com.travelapp.rest.dbconnection.JDBCConnection;


public class TripDAO {
	Connection conn = JDBCConnection.connectDatabase();
	Statement st = null;
	ResultSet rs = null;
	String query ="";
	TripBean trip = new TripBean();
	
	public void createItinerarye() {
		// TODO Auto-generated method stub
		
	}
	public void editItinerarye() {
		// TODO Auto-generated method stub
		
	}
	public void deleteItinerarye() {
		// TODO Auto-generated method stub
		
	}
	public void shareItinerarye() {
		// TODO Auto-generated method stub
		
	}
	public void createJournal() {
		// TODO Auto-generated method stub
		
	}
	public void editJournal() {
		// TODO Auto-generated method stub
		
	}
	public void deleteJournal() {
		// TODO Auto-generated method stub
		
	}
	public void shareJournal() {
		// TODO Auto-generated method stub
		
	}
	//list trip by userId
	public ArrayList<TripBean> listAllTripsByUserID(String userId) throws SQLException {
		// TODO Auto-generated method stub
		query="select tripUser.id,trip.name,,trip.groupId,trip.startTime,"
				+ "trip.endTime,"
				+ "trip.from,trip.to,trip.content"
		+ " from tripUser, trip"
		+ " where tripUser.userId = " + Integer.parseInt(userId);
		
		ArrayList<TripBean> trips = new ArrayList<TripBean>();
		st = conn.createStatement();
		rs = st.executeQuery(query);
		
		while (rs.next()) {
			trip.setName(rs.getString("name"));
			trip.setGroupId(Integer.parseInt(rs.getString("groupId")));
			trip.setStartTime(Integer.parseInt(rs.getString("startTime")));
			trip.setEndTime(Integer.parseInt(rs.getString("endTime")));
			trip.setFrom(rs.getString("from"));
		    trip.setTo(rs.getString("to"));
			trip.setContent(rs.getString("content"));
			trips.add(trip);
		}
		return trips;
	}
	
	public void createTrip(String name, String groupId, String from, String to,String startDate, String endDate,String content) throws SQLException {
		// TODO Auto-generated method stub
		query="insert into user(name, groupId, start_time,end_time,start_lc,end_lc,) values('"
				+ name + "', '"
				+ groupId + "', '" 
				+ startDate + "', '" 
				+ endDate + "', '" 
				+ from + "', '" 
			    + to + "', '" 
				+ content + "')";
		 st = conn.createStatement();
		 rs = st.executeQuery(query);
		
	}
	
	
	
	
}
