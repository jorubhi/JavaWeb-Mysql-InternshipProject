package com.sapient.pm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.pm.db.MySQLConnectionFactory;

import com.sapient.pm.model.StockOrder;

public class StockTable implements stockRepoInterface{

	@Override
	public ResultSet load(int id) throws SQLException {
		
		
		ResultSet rs;
		Connection connection=null;
		
			  connection = MySQLConnectionFactory.getConnection();

			String sql = "select * from jorawardb.stocks where tid=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,id);
			 rs  = ps.executeQuery();
			
			 return rs;
//			st1=new Stock();
//			
//			st1.setTid(rs.getInt(2));
//			st1.setSymbol(rs.getString(3));
//			st1.setQuantity(rs.getInt(4));
//			st1.setPrice(rs.getDouble(5));
//			st1.setStopLoss(rs.getDouble(6));
//			st1.setTargetPrice(rs.getDouble(7));

		
		
		
		
	}

		
	

	@Override
	public void push(StockOrder s) {
		// TODO Auto-generated method stub
		
	}

}
