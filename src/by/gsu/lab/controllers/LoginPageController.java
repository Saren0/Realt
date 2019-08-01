package by.gsu.lab.controllers;

import by.gsu.lab.db.ConnectionControl;
import by.gsu.lab.db.DBDataSetter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class LoginPageController extends AbstractBaseController {
    @Override
    protected void performTask(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String login = request.getParameter("username");
            String pass = request.getParameter("pass");
            //LoginPage loginPage = new LoginPage(login, pass);
            checkUser(login, pass);
            jump("/index.jsp", request, response);
        } catch (IllegalArgumentException ex) {
            jumpError("/index.jsp", ex.getMessage(), request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void checkUser(String a, String b)
            throws SQLException, ClassNotFoundException {
        Connection connection;
        try {
            connection = ConnectionControl.getConnection();
            new DBDataSetter().getUsers(connection, a, b);
        } finally {
            ConnectionControl.close();
        }
    }
}
