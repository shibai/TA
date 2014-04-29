package com.travelapp.rest.restservices;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserService {
		// create a new user
		@POST
		@Path("new")
		@Produces(MediaType.APPLICATION_JSON)
		public String createNewUser(
			@QueryParam("email") String email,
			@QueryParam("password") String password,
			@QueryParam("firstname") String firstname,
			@QueryParam("lastname") String lastname,
			@QueryParam("address") String address,
			@QueryParam("type") String type,
			@QueryParam("city") String city,
			@QueryParam("state") String state,
			@QueryParam("zipcode") String zipcode,
			@QueryParam("phone") String phone,
			@QueryParam("country") String country) {
			// TODO

			return null;
		}
		
		// edit a user
		@POST
		@Path("edit")
		@Produces(MediaType.APPLICATION_JSON)
		public String editUser(
			@QueryParam("email") String email,
			@QueryParam("password") String password,
			@QueryParam("firstname") String firstname,
			@QueryParam("lastname") String lastname,
			@QueryParam("address") String address,
			@QueryParam("type") String type,
			@QueryParam("city") String city,
			@QueryParam("state") String state,
			@QueryParam("zipcode") String zipcode,
			@QueryParam("phone") String phone,
			@QueryParam("country") String country) {
			// TODO

			return null;
		}
		
		//login
		@POST
		@Path("login")
		@Produces(MediaType.APPLICATION_JSON)
		public String logIn(@QueryParam("email") String email,@QueryParam("password") String password){
		   // TODO

			return null;
		}
		
		//signout
		@POST
		@Path("signout")
		@Produces(MediaType.APPLICATION_JSON)
		public String signOut(@QueryParam("email") String email,@QueryParam("password") String password){
			// TODO

			return null;
		}
		
		//accept user to a group
		@POST
		@Path("accpetuser")
		@Produces(MediaType.APPLICATION_JSON)
		public String accpetUser(@QueryParam("userid") String userid,@QueryParam("groupid") String groupid){
			// TODO

			return null;
		}
		
		//delete user
		@POST
		@Path("delete")
		@Produces(MediaType.APPLICATION_JSON)
		public String deleteUser(@QueryParam("userid") String userid){
			// TODO

			return null;
		}
		
		//search user
		@GET
		@Path("search")
		@Produces(MediaType.APPLICATION_JSON)
		public String searchUser(@QueryParam("userid") String userid){
			// TODO

			return null;
		}
		
		//list user by type
		@GET
		@Path("list")
		@Produces(MediaType.APPLICATION_JSON)
		public String lsitUserBy(@QueryParam("type") String type){
			// TODO

			return null;
		}
}
