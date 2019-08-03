package by.gsu.lab.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.lab.beans.Apartment;
import by.gsu.lab.beans.User;
import by.gsu.lab.db.ConnectionControl;
import by.gsu.lab.db.DBDataLoader;

@SuppressWarnings("serial")
public class ViewDataController extends AbstractBaseController {

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
			jumpError("/index.jsp", ex.getMessage(), request, response);
		} finally {
            ConnectionControl.close();
        }
	}
}
