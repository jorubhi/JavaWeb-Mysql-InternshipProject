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

import com.sapient.pm.model.Stock;
import com.sapient.pm.repository.RepositoryImplementation;

/**
 * Servlet implementation class PageControl2
 */
@WebServlet("/PageControl2")
public class PageControl2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageControl2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List<Stock> stockList = new ArrayList<>();
		String choice = request.getParameter("selected");
		String traderId  =request.getParameter("trader");
		int trader=Integer.parseInt(traderId);
		String ticker =request.getParameter("stock");
		
		
		Stock stock;

		
			ResultSet set;
			
				try {
					RepositoryImplementation implementation = new RepositoryImplementation();
					set = implementation.getData(choice,trader,ticker);
				

			
			while (set.next()) {
				stock = new Stock();
				stock.setTraderId(set.getString("traderId"));
				stock.setTicker(set.getString("ticker"));
				stock.setQuantity(set.getInt("quantity"));
				stock.setStatus(set.getInt("status"));
				
				stockList.add(stock);
			}

			request.setAttribute("stockList", stockList);
			request.getRequestDispatcher("orderbook.jsp").forward(request, response);
			System.out.println("helo");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
