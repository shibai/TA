package com.travelapp.rest.processes;

import java.sql.SQLException;
import java.util.ArrayList;

import com.travelapp.rest.beans.TripBean;
import com.travelapp.rest.daos.TripDAO;


public class TripProcess {
    TripDAO trip = new TripDAO();
    public ArrayList<TripBean> listAllTripsByUserID(String userId) throws SQLException{
		return trip.listAllTripsByUserID(userId);
	}
    public  TripBean createTrip(String name,String GropId,String From,String to,String StartDate,String EndDate,String content) throws SQLException{
    	TripBean tb = new TripBean();
    	tb.setName(name);
		tb.setGroupId(Integer.parseInt(GropId));
		tb.setFrom(From);
		tb.setTo(to);
		tb.setStartTime(Integer.parseInt(StartDate));
		tb.setEndTime(Integer.parseInt(EndDate));
		tb.setContent(content);
    	trip.createTrip(tb);
    	return tb;
	}
	public boolean createItinerarye(){
		trip.createItinerarye();
		return false;
	}
	public boolean editItinerary(){
		trip.editItinerarye();
		return false;
	}	
	public boolean deleteItinerary(){
		trip.deleteItinerarye();
		return false;
	}	
	public boolean shareItinerary(){
		trip.shareItinerarye();
		return false;
	}	
	//
	public boolean creaetJournal(){
		trip.createJournal();
		return false;
	}	
	public boolean editJournal(){
		trip.editJournal();
		return false;
	}	
	
	public boolean deleteJournal(){
		trip.deleteJournal();
		return false;
	}	
	public boolean shareJournal(){
		trip.shareJournal();
		return false;
	}
	
	

}
