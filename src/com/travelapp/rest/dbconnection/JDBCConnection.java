package com.travelapp.rest.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCConnection {
	
	private static String dbDriver = "com.mysql.jdbc.Driver";
	private static String username = "ta";
	private static String password = "0";
	private static String url = "jdbc:mysql://localhost/travelapp";

	public static Connection connectDatabase () {
		Connection connection = null;
		try {
			Class.forName(dbDriver).newInstance();
			connection = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection (ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 *  test for database connection
	 *  remember to set your own username and password
	 */
	public static void main (String[] arg0) {
		Connection connection = new JDBCConnection().connectDatabase();
		try {
			if (!connection.isClosed()) {
				System.out.println("you have a connection!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
