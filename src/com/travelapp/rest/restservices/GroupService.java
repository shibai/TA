package com.travelapp.rest.restservices;

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

import com.travelapp.rest.beans.GroupBean;
import com.travelapp.rest.beans.UserBean;
import com.travelapp.rest.processes.GroupProcess;




@Path("/group")
public class GroupService {
	
	@GET
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public String test() {
		return "ttttttttttttt";
	}

	GroupProcess groupProcess = new GroupProcess();
	
	// retrieve basic group information
	@GET
	@Path("view")
	@Produces(MediaType.APPLICATION_JSON)
	public GroupBean view(@QueryParam("groupId") String groupId) {
		return groupProcess.viewGroup(groupId);
	}

	// retrieve all users in a group
	@GET
	@Path("viewuser")
	@Produces(MediaType.APPLICATION_JSON)
	public UserBean[] viewUsers(@QueryParam("groupId") String groupId) {
		return groupProcess.viewMembers(groupId);
	}

	// create a new group
	@POST
	@Path("new")
	@Produces(MediaType.APPLICATION_JSON)
	public GroupBean createNewGroup(@QueryParam("userId") String userId,
			@QueryParam("name") String name, 
			@QueryParam("type") String type,
			@QueryParam("country") String country,
			@QueryParam("city") String city,
			@QueryParam("state") String state,
			@QueryParam("content") String content) {
		return groupProcess.createGroup(userId,name,type,country,city,state,content);
	}

	// add a user to group
	// return a boolean
	@PUT
	@Path("join")
	@Produces(MediaType.APPLICATION_JSON)
	public String addUser(@QueryParam("groupId") String groupId,
			@QueryParam("userId") String userId) {
		return groupProcess.addUser(groupId,userId);
	}

	// edit group info
	@PUT
	@Path("edit")
	@Produces(MediaType.APPLICATION_JSON)
	public GroupBean editGroup(@QueryParam("groupId") String groupId,
			@QueryParam("userId") String userId,
			@QueryParam("name") String name, 
			@QueryParam("type") String type,
			@QueryParam("country") String country,
			@QueryParam("city") String city,
			@QueryParam("state") String state,
			@QueryParam("content") String content) {

		return groupProcess.editGroup(groupId,userId,name,type,country,city,state,content);
	}

	// remove user from a group
	@POST
	@Path("remove")
	@Produces(MediaType.APPLICATION_JSON)
	public String removeUser(@QueryParam("groupId") String groupId,
			@QueryParam("userId") String userId) {
		
		return groupProcess.removeUser(groupId,userId);
	}

	// delete a group
	@PUT
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteGroup(@QueryParam("groupId") String groupId) {
		return groupProcess.deleteGroup(groupId);
	}

	// list groups
	// will have to break up this api to search by "country", "name", "city"
	// TODO ?????????????
	@GET
	@Path("listGroup")
	@Produces(MediaType.APPLICATION_JSON)
	public UserBean[] listGroup(@QueryParam("category") String category, @QueryParam("country") String country,
			@QueryParam("city") String city, @QueryParam("zipcode") String zipcode) {
		// TODO
		return null;
	}
	
	// TODO ????????????????????
	@POST
	@Path("recommend")
	@Produces(MediaType.APPLICATION_JSON)
	public String recommendGroup(@QueryParam("groupId") String groupId, @QueryParam("userId") String userId) {
		// TODO

		return null;
	}

}
