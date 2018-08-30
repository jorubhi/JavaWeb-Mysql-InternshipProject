package com.sapient.pm.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sapient.pm.db.MySQLConnectorFactory;
import com.sapient.pm.model.Trader;

public class JdbcRepository {

	public void save(Trader trader) {
		Connection connection = null;

		try {
			connection = MySQLConnectorFactory.getConnection();

			System.out.println(connection);
Date date=new Date(0);
			String sql = "insert into trader (traderId, ticker, quantity,  side) values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			System.out.println(trader.getTraderId());
			ps.setInt(1, trader.getTraderId());
			ps.setString(2, trader.getTicker());
			ps.setInt(3, trader.getQuantity());
			ps.setString(4, trader.getSide());

			ps.executeUpdate();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getMarketData(String s) throws SQLException {

		Connection connection = null;
		int rr = 0;

		connection = MySQLConnectorFactory.getConnection();

		String sql = "select * from marketData where ticker=?";

		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, s);
		ResultSet rs = ps.executeQuery();
		rs.next();
		rr = rs.getInt("price");
		connection.close();
		return rr;
		
		

	}

	public List<Trader> findAll() {
		Connection connection = null;
		List<Trader> traders = new ArrayList<>();

		try {
			connection = MySQLConnectorFactory.getConnection();
			String sql = "select ob.ticker, md.price, sum(ob.quantity)-(select sum(quantity) from orderbook where side = \"sell\" and status=1 and ticker=ob.ticker) from orderbook  ob \r\n"
					+ "join marketdata md \r\n" + "on md.ticker= ob.ticker\r\n"
					+ "where side = \"buy\" and status = 1 \r\n" + "group by ob.ticker";
			PreparedStatement ps = connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				Trader trader = new Trader();
				trader.setTicker(rs.getString(1));
				trader.setQuantity(rs.getInt(2));
				trader.setPrice(rs.getDouble(3));
				System.out.println(trader.getTicker());
				

				traders.add(trader);
				connection.close();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return traders;

	}

	public HashMap<String, Integer> getPortfolio() throws SQLException {
		HashMap<String, Integer> mapBuy = new HashMap<String, Integer>();
		HashMap<String, Integer> mapSell = new HashMap<String, Integer>();
		ArrayList<String> tickerList = new ArrayList<String>();// Tickers

		tickerList.add("SBB");
		tickerList.add("BAN");
		tickerList.add("GLI");
		tickerList.add("SRI");
		tickerList.add("SOL");
		tickerList.add("NES");
		tickerList.add("MOD");
		tickerList.add("MLK");
		tickerList.add("NCC");
		tickerList.add("SBI");

		for (String s : tickerList) {
			mapBuy.put(s.toUpperCase(), 0);
			mapSell.put(s.toUpperCase(), 0);
		}

		Connection connection = MySQLConnectorFactory.getConnection();
		String sql = "Select * from orderbook where status=? or ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, 1);
		statement.setInt(2, 2);
		System.out.println(statement);

		ResultSet rs = statement.executeQuery();
		String ticker, side;
		int quantity;
		while (rs.next()) {
			side = rs.getString("side");
			System.out.println(side);
			System.out.println(side);
			if (side.equalsIgnoreCase("buy")) {
				ticker = rs.getString("ticker");
				quantity = rs.getInt("quantity");
				System.out.println(quantity);
				mapBuy.put(ticker.toUpperCase(), mapBuy.get(ticker.toUpperCase()) + quantity);
			}
			if (side.equalsIgnoreCase("sell")) {
				ticker = rs.getString("ticker");
				quantity = rs.getInt("quantity");
				mapSell.put(ticker.toUpperCase(), mapSell.get(ticker.toUpperCase()) + quantity);
			}
		}

		for (String s : tickerList) {
			System.out.println(s + " " + mapBuy.get(s));
		}

		for (String s : tickerList) {
			System.out.println(s + " " + mapSell.get(s));
		}
		System.out.println("_________________________________________");

		for (String s : tickerList) {
			if (mapBuy.containsKey(s.toUpperCase())) {
				if (mapSell.containsKey(s.toUpperCase())) {
					mapBuy.put(s, mapBuy.get(s.toUpperCase()) - mapSell.get(s.toUpperCase()));
				}
			} else
				mapBuy.put(s, 0);
		}
		connection.close();

		return mapBuy;
	}

}
