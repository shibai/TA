package com.travelapp.rest.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.travelapp.rest.beans.GroupBean;
import com.travelapp.rest.beans.UserBean;


public class GroupDAO {

	// not tested
	// add deleted test in sql
	public GroupBean viewGroup (int groupId, Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from group where id = " + groupId;
		GroupBean gb = new GroupBean();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (!rs.next()) {
				System.out.println("invalid group id");
				return null;
			}
			
			gb.setId(rs.getInt("id"));
			gb.setName(rs.getString("name"));
			gb.setUserId(rs.getInt("userId"));
			gb.setCity(rs.getString("city"));
			gb.setContent(rs.getString("content"));
			gb.setCountry(rs.getString("country"));
			gb.setType(rs.getString("type"));
			gb.setState(rs.getString("state"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gb;
	}
	
	// not tested
	public UserBean[] viewMembers (int groupId, Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		String sql = "select user.id, user.email, user.firstName, user.lastName, user.address, user.city, user.state, user.zipcode, user.country"
				+ ", user.type, user.phone, user.url"
				+ " from group, user, groupUser"
				+ " where user.id = groupUser.userId and groupUser.groupID = " + groupId;
		ArrayList<UserBean> userBeans = new ArrayList<UserBean>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				UserBean ub = new UserBean();
				ub.setId(rs.getInt("id"));
				ub.setEmail(rs.getString("email"));
				ub.setFirsName(rs.getString("firstName"));
				ub.setLastname(rs.getString("firstName"));
				ub.setAddress(rs.getString("address"));
				ub.setCity(rs.getString("city"));
				ub.setState(rs.getString("state"));
				ub.setZipcode(rs.getString("country"));
				ub.setType(rs.getString("type"));
				ub.setPhone(rs.getString("phone"));
				ub.setUrl(rs.getString("url"));
				
				userBeans.add(ub);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// convert to basic array type
		UserBean[] ret = new UserBean[userBeans.size()];
		for (int i = 0; i < userBeans.size(); i++) {
			ret[i] = userBeans.get(i);
		}
		
		return ret;
	}
	
	// not tested
	public GroupBean createGroup (GroupBean gb, Connection conn) {
		Statement st = null;
		ResultSet rs = null;

		String sql = "insert into group(name, userId, city, state, country, type, content) values('" + gb.getName() + "', '" + gb.getUserId()
				+ "', '" + gb.getCity() + "', '" + gb.getState() + "', '" + gb.getCountry() 
				+ gb.getType() + "', '" + gb.getContent() + "')";
		
		try {
			st = conn.createStatement();
			int flag = st.executeUpdate(sql);
			
			if (flag == 0) {
				System.out.println("insert to group unsuccessful");
			}else {
				// get the unique id of last inserted row
				sql = "select_last_insert_id()";
				rs = st.executeQuery(sql);
				if (rs.next()) {
					gb.setId(rs.getInt("id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gb;
	}
	
	// add user to group
	public boolean addUser (int uid, int gid, Connection conn) {
		Statement st = null;
		String sql = "insert into groupUser(groupId,userId) values(" + gid + "," + uid + ")";
		
		try {
			st = conn.createStatement();
			int flag = st.executeUpdate(sql);
			if (flag == 0) {
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	// edit a group
	public GroupBean editGroup (GroupBean gb, Connection conn) {
		Statement st = null;
		String sql = "update group set userId = " + gb.getUserId() + ",name='" + gb.getName() + "',type='" + gb.getType() +"',city='" 
		+ gb.getCity() + "',state='" + gb.getState() + "',country='" + gb.getCountry() + "',content='" + gb.getContent() + "' where id=" + gb.getId();
		
		try {
			st = conn.createStatement();
			int flag = st.executeUpdate(sql);
			if (flag == 0) {
				System.out.println("Error in update group");
			}else {
				return gb;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// remove a user from a group
	// set 'deleted' to 0 in table groupUser
	// TODO: might have to make a few changes in any group/user related functions 
	public boolean removeUser (int uid, int gid, Connection conn) {
		Statement st = null;
		String sql = "update groupUser set deleted=1 where userId=" + uid + " and groupId=" + gid;
		boolean flag = false;
		
		try {
			st = conn.createStatement();
			if (st.executeUpdate(sql) == 0) {
				System.out.println("Error in remove user");
			}else {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	// delete a group
	// set 'deleted' to 0 in table group
	// TODO: might have to make a few changes in any group related functions 
	public boolean deleteGroup (int gid, Connection conn) {
		Statement st = null;
		String sql = "update group set deleted=1 where groupId=" + gid;
		boolean flag = false;
		
		try {
			st = conn.createStatement();
			if (st.executeUpdate(sql) == 0) {
				System.out.println("Error in delete group");;
			}else {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
