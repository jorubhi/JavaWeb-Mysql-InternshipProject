package com.sapient.pm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.sapient.pm.db.MySQLConnectionFactory;
import com.sapient.pm.web.servletfromlogin;

public class RepositoryImplementation  {

	private Connection connection;
	
	public RepositoryImplementation() throws SQLException {
		// TODO Auto-generated constructor stub
		MySQLConnectionFactory factory=new MySQLConnectionFactory();
		connection =factory.getConnection();
	}
		
	public ResultSet getData(String choice) throws SQLException {
		
		System.out.println(choice);
		String sql;
		PreparedStatement query;
		int ch=Integer.parseInt(choice);
		if(choice.equals("4")) {
			 sql="select * from ets_schema.orderbook where traderId=?";
			 query=connection.prepareStatement(sql);
			 query.setInt(1, servletfromlogin.tid);
				
		}
		else
		{sql="select * from ets_schema.orderbook where status=?";
		
		query=connection.prepareStatement(sql);
		query.setInt(1, ch);
		}
		
		
		ResultSet set=query.executeQuery();
		return set;
	}
	
	
	public ResultSet getData(String choice, int trader, String ticker) throws SQLException {
		 int c=0;
		 if(!choice.equals("all")) {
			 if(choice.equals("filled")) c=1;
			 if(choice.equals("partial")) c=3;
			 if(choice.equals("open")) c=0;
			 
		 }
		if (choice.equalsIgnoreCase("all") && trader==0 && ticker.equalsIgnoreCase("0")) {
			String sql = "select * from ets_schema.orderbook ;";
			PreparedStatement query = connection.prepareStatement(sql);
			ResultSet set = query.executeQuery();
			return set;
		}
		if (choice.equalsIgnoreCase("all") && trader==0 && !ticker.equalsIgnoreCase("0")) {
			String sql = "select * from ets_schema.orderbook where ticker=?;";			
			PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, ticker);
			ResultSet set = query.executeQuery();
			return set;
		}
		if (choice.equalsIgnoreCase("all") && trader!=0 && ticker.equalsIgnoreCase("0")) {
			String sql = "select * from ets_schema.orderbook where traderId=?;";			
			PreparedStatement query = connection.prepareStatement(sql);
			query.setInt(1, trader);
			ResultSet set = query.executeQuery();
			return set;
		}
		if (!choice.equalsIgnoreCase("all") && trader==0 && ticker.equalsIgnoreCase("0")) {
			String sql = "select * from ets_schema.orderbook where status=?;";			
			PreparedStatement query = connection.prepareStatement(sql);
			query.setInt(1, c);
			ResultSet set = query.executeQuery();
			return set;
		}
		
		if (choice.equalsIgnoreCase("all") && trader!=0 && !ticker.equalsIgnoreCase("0")) {
			String sql = "select * from ets_schema.orderbook where ticker=? and traderId=?;";			
			PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, ticker);
			query.setInt(2, trader);
			ResultSet set = query.executeQuery();
			return set;
		}
		if (!choice.equalsIgnoreCase("all") && trader==0 && !ticker.equalsIgnoreCase("0")) {
			String sql = "select * from ets_schema.orderbook where ticker=? and status=?; ";			
			PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, ticker);
			query.setInt(2, c);
			ResultSet set = query.executeQuery();
			return set;
		}
		if (!choice.equalsIgnoreCase("all") && trader!=0 && ticker.equalsIgnoreCase("0")) {
			String sql = "select * from ets_schema.orderbook where traderId=? and status=?; ";			
			PreparedStatement query = connection.prepareStatement(sql);
			query.setInt(1, trader);
			query.setInt(2, c);
			ResultSet set = query.executeQuery();
			return set;
		}
		
		
		
		
			String sql = "select * from ets_schema.orderbook where traderId=? and ticker=? and status=? and transactiondate=( select date(sysdate()));";			
			PreparedStatement query = connection.prepareStatement(sql);
			query.setInt(1, trader);
			query.setString(2, ticker);
			query.setInt(3, c);

			ResultSet set = query.executeQuery();
			return set;
		


	}
	public boolean putData()
	{
				
		return false;
	}

}
