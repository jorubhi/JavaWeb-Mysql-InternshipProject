package com.sapient.pm.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sapient.pm.model.StockOrder;

public interface stockRepoInterface {
	public ResultSet load(int id) throws SQLException;
	public void push(StockOrder s);

}
