package com.travelapp.rest.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.travelapp.rest.beans.*;
import com.travelapp.rest.processes.GroupProcess;



public class test {

	// example of how to test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test t = new test();
		
		// you can write your own test method and comment out others';
		t.groupTest();	
	}
	
	
	public void groupTest () {
		GroupProcess groupProcess = new GroupProcess();
		// GroupBean gb = groupProcess.createGroup("1", "group1", "this is type", "this is country", "this is city", "this is state", "this is content");
		
		// String flag = groupProcess.addUser("11","2");
		/*
		UserBean[] ub = groupProcess.viewMembers("11");
		for (int i = 0; i < ub.length; i++) {
			System.out.println(ub[i].getId());
		}
		*/
		
		// GroupBean gb = groupProcess.editGroup("11","2","new group name","new type","new country","new city","new state","new content");
		
		String flag = groupProcess.deleteGroup("11");
		
		System.out.println(flag);
		
	}

}
