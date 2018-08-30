package com.sapient.pm.apps;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.sapient.pm.BlockLogic.BlockCreator;
import com.sapient.pm.BlockLogic.BlockExecutor;
import com.sapient.pm.BlockLogic.PartialExecutor;
import com.sapient.pm.repository.JdbcRepository;
import com.sapient.pm.repository.reposit;



public class App3 {
	
	public static void main(String[] args) throws SQLException {
		
	
	JdbcRepository j = new JdbcRepository();
	
	
	    System.out.println(j.getMarketData("SBI"));
	    
	    
	    
//		reposit repository = new reposit();
	    
	    
//
//		ResultSet resultSet = repository.getData();
//
//		BlockCreator creator=new BlockCreator();
//		
//		creator.blockCreator();
//		
//		Map<String, Integer>mapBuy=creator.buyBlock;
//		Map<String, Integer>mapSell=creator.sellBlock;
//	
//		mapBuy.clear();
////		
////		PartialExecutor executor=new PartialExecutor();
////		executor.blockCreator();
////		Map<String, ArrayList<Integer>> buy=executor.buyBlockExecutor();
////		Map<String, ArrayList<Integer>> sell=executor.sellBlockExecutor();
//		
////		while(resultSet.next()) {
////			System.out.println(resultSet.getString("ticker"));
////			
////			System.out.println(resultSet.getInt("Quantity"));
////		}
//		
//		for(String s:mapBuy.keySet())
//		{
//
//			System.out.print(s+" ");
//			System.out.print(mapBuy.get(s)+" ");
//		}
//		System.out.println();
//		for(String s:mapSell.keySet())
//		{
//			System.out.print(s+" ");
//			System.out.print(mapSell.get(s)+"  ");
//		}
//		System.out.println();
//		
//		for(String s:buy.keySet())
//		{
//			System.out.print(s+" ");
//			System.out.print(buy.get(s)+"  ");
//		}
//		System.out.println();
//		
//		for(String s:sell.keySet())
//		{
//			System.out.print(s+" ");
//			System.out.print(sell.get(s)+"  ");
//		}
//		System.out.println();
		
	}
}
