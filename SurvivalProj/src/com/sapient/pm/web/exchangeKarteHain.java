package com.sapient.pm.web;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.pm.BlockLogic.BlockExecutor;
import com.sapient.pm.model.StockOrder;
import com.sapient.pm.repository.reposit;


/**
 * Servlet implementation class Servletforexecute
 */
@WebServlet("/callRefresh")
public class exchangeKarteHain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	StockOrder stock=new StockOrder();
    public exchangeKarteHain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BlockExecutor b = new BlockExecutor();
		
			
			  b.executeBlockRandomly();
			  
				
			  
		
		
		response.sendRedirect("display-view.jsp");
		
		
		
		
	}
	
		
	

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		   

	}
}


