package by.ander.web.controllers;

import by.ander.web.db.ConnectionControl;
import by.ander.web.db.DBDataSetter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class InsertUser extends AbstractBaseController {
 
	@Override
	protected void performTask(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String login = request.getParameter("Login");
			String password = request.getParameter("Password");
			String root = request.getParameter("Root");
			doInsertUser(login, password, root);
			jump("/ViewDataController", request, response);
		} catch (IllegalArgumentException | SQLException | ClassNotFoundException ex) {
			jumpError("/admin.jsp", ex.getMessage(), request, response);
		}
	}

	private void doInsertUser(String login, String password, String root) throws SQLException, ClassNotFoundException {
		Connection connection;
		try {
			connection = ConnectionControl.getConnection();
	    	new DBDataSetter().insertUser(connection, login, password, root);
		} finally {
            ConnectionControl.close();
        }
	}
}
