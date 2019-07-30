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
public class InsertArrive extends AbstractBaseController {
	 
		@Override
		protected void performTask(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			try {
				request.setCharacterEncoding("UTF-8");
				String oblast_znani = request.getParameter("OZ_a");
				String index = request.getParameter("Index_a");
				String colvo = request.getParameter("Kolvo_a");
				String date = request.getParameter("Date_a");
				doInsertArrive(oblast_znani, index, colvo, date);
				jump("/ViewDataController", request, response);
			} catch (IllegalArgumentException | SQLException | ClassNotFoundException ex) {
				jumpError("/index.jsp", ex.getMessage(), request, response);
			}
		}

		private void doInsertArrive(String a, String b, String c, String d) 
				throws SQLException, ClassNotFoundException {
			Connection connection;
			try {
				connection = ConnectionControl.getConnection();
		    	new DBDataSetter().insertArrive(connection, a, b, c, d);
			} finally {
	            ConnectionControl.close();
	        }
		}
}
