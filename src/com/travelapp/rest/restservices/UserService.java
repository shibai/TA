package com.travelapp.rest.restservices;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.travelapp.rest.beans.UserBean;
import com.travelapp.rest.processes.UserProcess;

@Path("/user")
public class UserService {
	     
	    UserProcess up = new UserProcess();
		// create a new user
		@POST
		@Path("new")
		@Produces(MediaType.APPLICATION_JSON)
		public UserBean createNewUser(
			@QueryParam("email") String email,
			@QueryParam("password") String password,
			@QueryParam("firstName") String firstname,
			@QueryParam("lastName") String lastname,
			@QueryParam("address") String address,
			@QueryParam("city") String city,
			@QueryParam("state") String state,
			@QueryParam("zipcode") String zipcode,
			@QueryParam("phone") String phone,
			@QueryParam("country") String country,
			@QueryParam("type") String type,
			@QueryParam("url") String url) throws SQLException {
			// TODO
            
			return up.createUser(email, firstname, lastname, password, address, city, zipcode, state, country, phone, type,url);
		}
		
		// edit a user
		@PUT
		@Path("edit")
		@Produces(MediaType.APPLICATION_JSON)
		public UserBean editUser(
				@QueryParam("email") String email,
				@QueryParam("password") String password,
				@QueryParam("firstName") String firstname,
				@QueryParam("lastName") String lastname,
				@QueryParam("address") String address,
				@QueryParam("city") String city,
				@QueryParam("state") String state,
				@QueryParam("zipcode") String zipcode,
				@QueryParam("phone") String phone,
				@QueryParam("country") String country,
				@QueryParam("type") String type,
				@QueryParam("url") String url) throws SQLException {
			// TODO

			
			return up.editUser(email, firstname, lastname, password, address, city, zipcode, state, country, phone, type, url);
		}
		
		//login
		@POST
		@Path("login")
		@Produces(MediaType.APPLICATION_JSON)
		public boolean logIn(@QueryParam("email") String email,@QueryParam("password") String password) throws SQLException{
		   // TODO

			return up.userLogin(email, password);
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
		
		//delete user pass
		@POST
		@Path("delete")
		@Produces(MediaType.APPLICATION_JSON)
		public boolean deleteUser(@QueryParam("userid") String userid) throws SQLException{
			// TODO

			return up.deleteUser(userid);
		}
		
		//search user pass
		@GET
		@Path("search")
		@Produces(MediaType.APPLICATION_JSON)
		public UserBean searchUser(@QueryParam("userid") String userid) throws SQLException{
			// TODO

			return up.searchUser(userid);
		}
		
		//list user by type
		@GET
		@Path("list")
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<UserBean> lsitUserBy(@QueryParam("type") String type) throws SQLException{
			// TODO

			return up.listAllUsers();
		}
}
