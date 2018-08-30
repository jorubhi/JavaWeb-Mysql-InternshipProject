package com.sapient.pm.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionFactory {
 
	static {
		try {
			DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()throws SQLException {
		String url="jdbc:mysql://localhost:3333/ets_schema";
		String user="root";
		String password="abcd1234";
		Connection con=DriverManager.getConnection(url, user, password);
		return con;
	}

}








