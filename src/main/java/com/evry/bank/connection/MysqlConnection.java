package com.evry.bank.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	
	
	//private static MysqlConnection con;
	
	public static Connection getConnection()  {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EVRYBANK?autoReconnect=true&useSSL=false","root","root");
		} 
		catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}  
		return con;
	}

}
