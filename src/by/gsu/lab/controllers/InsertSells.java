package by.gsu.lab.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.lab.db.ConnectionControl;
import by.gsu.lab.db.DBDataSetter;

@SuppressWarnings("serial")
public class InsertSells extends AbstractBaseController {
	 
		@Override
		protected void performTask(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			try {
				request.setCharacterEncoding("UTF-8");
				String oblast_znani = request.getParameter("OZ_s");
				String index = request.getParameter("Index_s");
				String colvo = request.getParameter("Kolvo_s");
				String price = request.getParameter("Price_s");
				String date = request.getParameter("Date_s");
				doInsertSell(oblast_znani, index, colvo, price, date);
				jump("/ViewDataController", request, response);
			} catch (IllegalArgumentException | SQLException | ClassNotFoundException ex) {
				jumpError("/index.jsp", ex.getMessage(), request, response);
			}
		}

		private void doInsertSell(String a, String b, String c, String d, String e) 
				throws SQLException, ClassNotFoundException {
			Connection connection;
			try {
				connection = ConnectionControl.getConnection();
		    	new DBDataSetter().insertSells(connection, a, b, c, d, e);
			} finally {
	            ConnectionControl.close();
	        }
		}
}
