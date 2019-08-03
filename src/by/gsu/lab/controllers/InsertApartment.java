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
public class InsertApartment extends AbstractBaseController {

    @Override
    protected void performTask(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("OZ_a");
            String bedroom = request.getParameter("Index_a");
            String square = request.getParameter("Kolvo_a");
            String price = request.getParameter("Date_a");
			String phone = request.getParameter("Kolvo_a");
			String picture = request.getParameter("Date_a");
            doInsertApartment(name, bedroom, square, price, phone, picture);
            jump("/ViewDataController", request, response);
        } catch (IllegalArgumentException | SQLException | ClassNotFoundException ex) {
            jumpError("/index.jsp", ex.getMessage(), request, response);
        }
    }

    private void doInsertApartment(String name, String bedroom, String square, String price,
								   String phone, String picture) throws SQLException, ClassNotFoundException {
        Connection connection;
        try {
            connection = ConnectionControl.getConnection();
            new DBDataSetter().insertApartment(connection, name, bedroom, square, price, phone, picture);
        } finally {
            ConnectionControl.close();
        }
    }
}
