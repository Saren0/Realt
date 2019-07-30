package by.gsu.lab.controllers;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import by.gsu.lab.db.*;

@SuppressWarnings("serial")
public class InsertBooks extends AbstractBaseController {
 
	@Override
	protected void performTask(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String oblast_znani = request.getParameter("OZ_k");
			String index = request.getParameter("In_v_kat_k");
			String author = request.getParameter("Author_k");
			String nazvanie = request.getParameter("Nazvanie_k");
			String year = request.getParameter("Year_k");			
			String price = request.getParameter("Price_k");
			doInsertDots(oblast_znani, index, author, nazvanie, year, price);
			jump("/ViewDataController", request, response);
		} catch (IllegalArgumentException | SQLException | ClassNotFoundException ex) {
			jumpError("/index.jsp", ex.getMessage(), request, response);
		}
	}

	private void doInsertDots(String a, String b, String c, String d, String e, String f) 
			throws SQLException, ClassNotFoundException {
		Connection connection;
		try {
			connection = ConnectionControl.getConnection();
	    	new DBDataSetter().insertBooks(connection, a, b, c, d, e, f);
		} finally {
            ConnectionControl.close();
        }
	}
}
