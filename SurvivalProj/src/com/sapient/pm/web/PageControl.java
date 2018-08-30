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



@WebServlet(urlPatterns = { "/FetchData","/PageControl" })
public class PageControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RepositoryImplementation implementation;

	public PageControl() throws SQLException {
		super();
		implementation = new RepositoryImplementation();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String choice = request.getParameter("selected");
		Stock stock;
		List<Stock> stockList = new ArrayList<>();

		try {
			ResultSet set = implementation.getData(choice);
			while (set.next()) {
				stock = new Stock(set.getInt("quantity"), set.getInt("status"),
				set.getString("ticker"));
				System.out.println(set.getInt("status"));
				
				System.out.println(set.getInt("quantity"));
				System.out.println(set.getString("ticker"));
				
				stockList.add(stock);
			}

			request.setAttribute("stockList", stockList);
			request.getRequestDispatcher("display-view.jsp").forward(request, response);

			// response.sendRedirect("index.html");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
