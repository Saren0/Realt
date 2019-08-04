package by.ander.web.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.ander.web.db.ConnectionControl;
import by.ander.web.db.DBDataSetter;

@SuppressWarnings("serial")
public class InsertApartment extends AbstractBaseController {

    @Override
    protected void performTask(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("Name");
            String bedroom = request.getParameter("Bedroom");
            String square = request.getParameter("Square");
            String price = request.getParameter("Price");
			String phone = request.getParameter("Phone");
			String picture = request.getParameter("Picture");
            doInsertApartment(name, bedroom, square, price, phone, picture);
            jump("/ViewDataController", request, response);
        } catch (IllegalArgumentException | SQLException | ClassNotFoundException ex) {
            jumpError("/admin.jsp", ex.getMessage(), request, response);
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
