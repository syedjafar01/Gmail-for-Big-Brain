package com.razorthink.trackmymail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCHelper 
{
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(Constants.url, Constants.user, Constants.password);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println(con);
		return con;
	}
}
