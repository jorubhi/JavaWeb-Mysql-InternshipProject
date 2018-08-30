package com.sapient.pm.repository;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sapient.pm.db.MySQLConnectionFactory;
import com.sapient.pm.model.StockOrder;
import com.sapient.pm.web.servletfromlogin;	

		


public class reposit {

	private Connection connection;

	public reposit() throws SQLException {
		// TODO Auto-generated constructor stub
		MySQLConnectionFactory factory = new MySQLConnectionFactory();
		connection = factory.getConnection();
	}

	public ResultSet getData() throws SQLException {
		String sql = "select * from ets_schema.trader where traderId=? ";
		
		PreparedStatement query = connection.prepareStatement(sql);
		query.setInt(1,servletfromlogin.tid);
		ResultSet set = query.executeQuery();
		
		
		return set;
		
//		String sql = "select * from ets_schema.trader";
//		PreparedStatement query = connection.prepareStatement(sql);
//		ResultSet set = query.executeQuery();
//		return set;
	
		
		
	}
//
//	public void putData(StockOrder s) throws SQLException {
//		String sql="insert into jorawardb.stocks2(Name,Symbol,Quantity,Status) values(?,?,?,0)";
//			PreparedStatement query = connection.prepareStatement(sql);
//			
//			
//			query.setString(1,s.getSymbol());
//			query.setString(2,s.getSymbol());
//			query.setInt(3,s.getQuantity());
//			
//			int count = query.executeUpdate();
//			System.out.println(count);
//			if (count == 1) {
//				System.out.println("New Product inserted..");
//			}
//
//			
//	}
	
	
	
	public void putDataInOrderTable(StockOrder s) throws SQLException {
		String sql="insert into ets_schema.orderbook(Ticker,Quantity,Status,traderId,side) values(?,?,0,?,?)";
			PreparedStatement query = connection.prepareStatement(sql);
			Date date=new Date(0);
			query.setString(1,s.getSymbol());
			query.setInt(2,s.getQuantity());
			query.setString(4,s.getSide());
			query.setInt(3,servletfromlogin.tid);

			int count = query.executeUpdate();
			System.out.println(count);
			if (count == 1) {
				System.out.println("New Product inserted..");
			}

			
	}

	
	

	public void deleteTrader() {
		System.out.println("sdgfb");
		String sql2 = "delete from ets_schema.trader  where traderId=?  ";
		PreparedStatement query2;
		
		try {
			query2= connection.prepareStatement(sql2);
			query2.setInt(1,servletfromlogin.tid);
			query2.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public ResultSet getUserNames() throws SQLException {
	
	String sql = "select * from ets_schema.login";
	ResultSet set;
	PreparedStatement query;
	
		query = connection.prepareStatement(sql);
	
	 set = query.executeQuery();
	 return set;


}
public int getProcessedQ(String ticker) throws SQLException
{
	String sql="select processesdQ from ets_schema where status=3 and ticker=?";
	PreparedStatement statement=connection.prepareStatement(sql);
	statement.setString(1, ticker);
	ResultSet resultSet=statement.executeQuery();
	resultSet.next();
	return resultSet.getInt(1);
	
}


}
