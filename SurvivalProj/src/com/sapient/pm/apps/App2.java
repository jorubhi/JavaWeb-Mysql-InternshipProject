package com.sapient.pm.apps;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.pm.model.Stock;
import com.sapient.pm.model.StockOrder;
import com.sapient.pm.repository.StockTable;
import com.sapient.pm.repository.reposit;
import com.sapient.pm.repository.stockRepoInterface;

public class App2 {
	
	public static void main(String[] args) throws SQLException {
		
	
	//stockRepoInterface s = new StockTable();
		
		reposit r= new reposit();
ResultSet result = r.getData();
	Stock s1  = new Stock();
List<Stock> slist= new ArrayList<Stock>();
//StockOrder st1;

//while(result.next()) {
//	st1=new StockOrder();
//	
//	st1.setTid(result.getInt(2));
//	st1.setSymbol(result.getString(3));
//	st1.setQuantity(result.getInt(4));
//	st1.setPrice(result.getDouble(5));
//	st1.setStopLoss(result.getDouble(6));
//	st1.setTargetPrice(result.getDouble(7));
//	slist.add(st1);
//
//}
System.out.println(result);
while(result.next()) {
	       
	//(traderId, ticker, quantity, price, side) values(1, "app", 3000, 30, "buy")

	    System.out.println(result.getString("ticker"));
	    System.out.println(result.getInt("quantity"));
	    //System.out.println(result.getInt(4));
	    System.out.println(	result.getString("side"));
	    System.out.println(	result.getDouble("price"));
	    
//	    result.getString(3);
//		result.getInt(4);
//		result.getString(6);
//		result.getInt(5);

}		
	
//for(StockOrder iterator:slist) {
//	System.out.println(iterator.getPrice());
//}
//System.out.println(slist);
	
	
	
	
	
	
	
	
	}
	
	

}
