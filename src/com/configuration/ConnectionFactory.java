package com.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public static Connection getConnection() throws SQLException
	{
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrmangement","root","Riyaz@123");
		return con;
	}


}
