package com.sapient.pm.BlockLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.sapient.pm.repository.reposit;

public class BlockCreator {
	public Map<String, Integer> buyBlock = new HashMap<String, Integer>();
	public Map<String, Integer> sellBlock = new HashMap<String, Integer>();

	public void blockCreator() throws SQLException {

		reposit repository = new reposit();
		ResultSet result = repository.getData();

		// while (resultSet.next()) {
		// result.getString("ticker"));
		// System.out.println(result.getInt("quantity"));
		// //System.out.println(result.getInt(4));
		// System.out.println( result.getString("side"));
		// System.out.println( result.getDouble("price"));
		// if (resultSet.getI) {

		while (result.next()) {
			if (result.getString("side").equals("buy")) {
				
				
				if (!buyBlock.containsKey(result.getString("ticker"))) {
					buyBlock.put(result.getString("ticker"), 0);

				} 
					
					buyBlock.put(result.getString("ticker"),
							buyBlock.get(result.getString("ticker")) + result.getInt("quantity"));
				
			} 
			
			
			
			else {
				if (!sellBlock.containsKey(result.getString("ticker"))) {
					sellBlock.put(result.getString("ticker"), 0);
				} 
					sellBlock.put(result.getString("ticker"),
							sellBlock.get(result.getString("ticker")) + result.getInt("quantity"));
				

			}
		}

	}

}
