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
    public void createTrip(String name,String GropId,String From,String to,String StartDate,String EndDate,String content) throws SQLException{
		trip.createTrip(name,GropId,From,to,StartDate,EndDate,content);
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
