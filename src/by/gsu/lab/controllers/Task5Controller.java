package by.gsu.lab.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.lab.db.ConnectionControl;
import by.gsu.lab.db.DBDataLoader;

@SuppressWarnings("serial")
public class Task5Controller extends AbstractBaseController {

	@Override
	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection;
		try {
			request.setCharacterEncoding("UTF-8");
			
			String bookCount = request.getParameter("bookCount");
			String bookName = request.getParameter("bookName");
			
			connection = ConnectionControl.getConnection();
			DBDataLoader loader = new DBDataLoader();
			
			List<List<String>> dots = loader.getAllBooksByNameAndCount(connection, bookCount, bookName);
			request.setAttribute("task5ResultList", dots);
			jump("/task5-result.jsp", request, response);
		} catch (IllegalArgumentException | SQLException | ClassNotFoundException ex) {
			jumpError("/task5.jsp", ex.getMessage(), request, response);
		} finally {
            ConnectionControl.close();
        }
	}

}
