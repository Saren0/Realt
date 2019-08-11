package by.ander.web.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.ander.web.beans.User;
import by.ander.web.db.ConnectionControl;
import by.ander.web.db.DBDataLoader;
import by.ander.web.beans.Apartment;

@SuppressWarnings("serial")
public class AdminPageController extends AbstractBaseController {

	@Override
	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection;
		try {
			connection = ConnectionControl.getConnection();
			DBDataLoader loader = new DBDataLoader();

			List<User> users = loader.getAllUsers(connection);
			List<List<String>> usersForTable = new ArrayList<>();
			users.forEach(user -> usersForTable.add(user.getUsersList()));
			request.setAttribute("usersList", usersForTable);

			List<Apartment> apartments = loader.getAllApartments(connection);
			List<List<String>> apartmentsForTable = new ArrayList<>();
			apartments.forEach(apartment -> apartmentsForTable.add(apartment.getApartmentList()));
			request.setAttribute("apartmentsList", apartmentsForTable);

			jump("/view.jsp", request, response);
		} catch (IllegalArgumentException | SQLException | ClassNotFoundException ex) {
			jumpError("/admin.jsp", ex.getMessage(), request, response);
		} finally {
            ConnectionControl.close();
        }
	}
}
