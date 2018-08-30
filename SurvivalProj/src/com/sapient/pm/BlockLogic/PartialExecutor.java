package com.sapient.pm.BlockLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sapient.pm.repository.reposit;

public class PartialExecutor {
	
	
	public Map<String, Integer> buyBlock = new HashMap<String, Integer>();
	
	public Map<String, Integer> sellBlock = new HashMap<String, Integer>();
	Map<String, ArrayList<Integer>> buyBlockExecuted = new HashMap<String, ArrayList<Integer>>();
	Map<String, ArrayList<Integer>> sellBlockExecuted = new HashMap<String, ArrayList<Integer>>();

	public void blockCreator() throws SQLException {
		reposit repository = new reposit();
		ResultSet resultSet = repository.getData();

		while (resultSet.next()) {

			if (resultSet.getInt("SIDE") == 1) {

				if (!buyBlock.containsKey(resultSet.getString("SYMBOL"))) {
					buyBlock.put(resultSet.getString("SYMBOL"), 0);
				}

				buyBlock.put(resultSet.getString("SYMBOL"),
						buyBlock.get(resultSet.getString("SYMBOL")) + resultSet.getInt("QUANTITY"));
			} else {
				if (!sellBlock.containsKey(resultSet.getString("SYMBOL"))) {
					sellBlock.put(resultSet.getString("SYMBOL"), 0);
				}
				sellBlock.put(resultSet.getString("SYMBOL"),
						sellBlock.get(resultSet.getString("SYMBOL")) + resultSet.getInt("QUANTITY"));
			}
		}

	}

	public Map<String, ArrayList<Integer>> buyBlockExecutor() {
		int window, quantity;
		Random random = new Random();
		for (String s : buyBlock.keySet()) {
			quantity = buyBlock.get(s);
			window = random.nextInt(buyBlock.get(s)) + 1;
			ArrayList<Integer> list = new ArrayList<>();
			while (quantity > 0) {
				if (quantity >= window) {
					list.add(window);
					quantity -= window;
				} else {
					list.add(quantity);
					quantity = 0;
				}
			}
			buyBlockExecuted.put(s, list);
		}
		return buyBlockExecuted;
	}

	public Map<String, ArrayList<Integer>> sellBlockExecutor() {
		int window, quantity;
		Random random = new Random();
		for (String s : sellBlock.keySet()) {
			quantity = sellBlock.get(s);
			window = random.nextInt(sellBlock.get(s)) + 1;
			ArrayList<Integer> list = new ArrayList<>();
			while (quantity > 0) {
				if (quantity >= window) {
					list.add(window);
					quantity -= window;
				} else {
					list.add(quantity);
					quantity = 0;
				}
			}
			sellBlockExecuted.put(s, list);
		}
		return sellBlockExecuted;
	}


}
