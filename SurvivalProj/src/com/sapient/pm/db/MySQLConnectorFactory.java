package com.sapient.pm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;



public class MySQLConnectorFactory {
	static {
		
		try {
			DriverManager.registerDriver(new Driver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() throws SQLException {
		
		String url="jdbc:mysql://localhost:3333/ets_schema?autoReconnect=true&useSSL=false";
		String user = "root";
		String password="abcd1234";
		Connection con = DriverManager.getConnection(url,user,password);
		return con;
	}
	
}
