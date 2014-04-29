package com.travelapp.rest.restservices;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/trip")
public class TripService {
	    //create a trip
		@POST
		@Path("new")
		@Produces(MediaType.APPLICATION_JSON)
		public String createTrip(
		@QueryParam("id") String id,
		@QueryParam("groupId") String groupId,
		@QueryParam("startTime") String startTime,
		@QueryParam("endTime") String endTime,
		@QueryParam("from") String from,
		@QueryParam("to") String to,
		@QueryParam("content") String content){
		// TODO

		return null;
	    }
	    //list trip by userId
		@GET
		@Path("list")
		@Produces(MediaType.APPLICATION_JSON)
		public String lsitTripByUserId(@QueryParam("userId") String userId){
			// TODO

			return null;
		}
		/*Itinerary management
		create new itinerary*/
		@POST
		@Path("itinerary/new")
		@Produces(MediaType.APPLICATION_JSON)
		public String createItinerary(
		@QueryParam("tripid") String tripid,
		@QueryParam("carbookingid") String carbookingid,
		@QueryParam("hotelbookingid") String hotelbookingid,
		@QueryParam("flightbookingid") String flightbookingid){
			// TODO

			return null;
		}
		
		//view itinerary
		@GET
		@Path("itinerary/view")
		@Produces(MediaType.APPLICATION_JSON)
		public String viewItinerary(@QueryParam("itineraryid") String itineraryid){
			// TODO

			return null;
		}
		
		//edit itinerary
		@POST
		@Path("itinerary/edit")
		@Produces(MediaType.APPLICATION_JSON)
		public String editItinerary(
		@QueryParam("tripid") String tripid,
		@QueryParam("carbookingid") String carbookingid,
		@QueryParam("hotelbookingid") String hotelbookingid,
		@QueryParam("flightbookingid") String flightbookingid){
			// TODO

			return null;
		}
		
		
		//delete itinerary
		@POST
		@Path("itinerary/delete")
		@Produces(MediaType.APPLICATION_JSON)
		public String deleteItinerary(@QueryParam("itineraryid") String itineraryid){
			// TODO

			return null;
		}
		
		//share itinerary
		@GET
		@Path("itinerary/share")
		@Produces(MediaType.APPLICATION_JSON)
		public String shareItinerary(@QueryParam("itineraryid") String itineraryid){
			// TODO

			return null;
		}
		
		
		//create new journal
		@POST
		@Path("journal/new")
		@Produces(MediaType.APPLICATION_JSON)
		public String createJournal(
		@QueryParam("intneraryid") String interaryid,
		@QueryParam("text") String text){
			// TODO

			return null;
		}
		
		/* Journal management
		view journal*/
		@GET
		@Path("journal/view")
		@Produces(MediaType.APPLICATION_JSON)
		public String viewJournal(@QueryParam("journalid") String itineraryid){
			// TODO

			return null;
		}
		
		//edit journal
		@POST
		@Path("journal/edit")
		@Produces(MediaType.APPLICATION_JSON)
		public String editJournal(
		@QueryParam("journalid") String journalid,
		@QueryParam("text") String text){
			// TODO

			return null;
		}
		
		
		//delete journal
		@POST
		@Path("journal/delete")
		@Produces(MediaType.APPLICATION_JSON)
		public String deleteJournal(@QueryParam("journalid") String journalid){
			// TODO

			return null;
		}
		
		//share journal
		@GET
		@Path("journal/share")
		@Produces(MediaType.APPLICATION_JSON)
		public String shareJournal(@QueryParam("journalid") String journalid){
			// TODO

			return null;
		}
}
