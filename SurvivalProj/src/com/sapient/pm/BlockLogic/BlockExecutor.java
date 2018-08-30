package com.sapient.pm.BlockLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.sapient.pm.db.MySQLConnectorFactory;

public class BlockExecutor {

	private Connection connection;
	
	public void executeBlockRandomly() {
		
		int choice, qpart, quant = 0;
		
		
		
		
		try {
			connection = MySQLConnectorFactory.getConnection();
			Random random = new Random();
			int id;
			String sql_fetch_quantity = "select * from ets_schema.orderbook where status=0";
			PreparedStatement res = connection.prepareStatement(sql_fetch_quantity);
			ResultSet result = res.executeQuery();
			while(result.next()) {
				choice = random.nextInt(3) + 1;
				if(choice==1) {
					id= result.getInt(1);
					System.out.println(id);
					String sql = "update ets_schema.orderbook set status=?, processedQ=? where orderId=?";
					PreparedStatement query = connection.prepareStatement(sql);
					query.setInt(1, 1);
					query.setInt(2, result.getInt("quantity"));
					query.setInt(3, id);
					int set = query.executeUpdate();
				}
				if(choice==2) {
					id= result.getInt(1);
					String sql = "update ets_schema.orderbook set status=?, processedQ=? where orderId=?";
					PreparedStatement query = connection.prepareStatement(sql);
					query.setInt(1, 2);
					query.setInt(2, 0);
					query.setInt(3, id);
					int set = query.executeUpdate();
					
				}
				else if(choice==3){
					qpart = random.nextInt(result.getInt("quantity")) + 1;
					if(result.getInt("quantity")%qpart==0) {
						id= result.getInt(1);
						String sql = "update ets_schema.orderbook set status=?, processedQ=? where orderId=?";
						PreparedStatement query = connection.prepareStatement(sql);
						query.setInt(1, 1);
						query.setInt(2, result.getInt("quantity"));
						query.setInt(3, id);
						int set = query.executeUpdate();
					}
					else
					{	id= result.getInt(1);
						String sql = "update ets_schema.orderbook set status=?, processedQ=? where orderId=?";
						PreparedStatement query = connection.prepareStatement(sql);
						query.setInt(1, 3);
						query.setInt(2, qpart);
						query.setInt(3, id);
						int set = query.executeUpdate();
					}
					
					
				}
				
			}
			
	
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}