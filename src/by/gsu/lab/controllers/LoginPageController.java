package by.gsu.lab.controllers;

import by.gsu.lab.beans.LoginPage;
import by.gsu.lab.db.ConnectionControl;
import by.gsu.lab.db.DBDataLoader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class LoginPageController extends AbstractBaseController {
    private LoginPage loginPage;

    @Override
    protected void performTask(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String login = request.getParameter("username");
            String pass = request.getParameter("pass");
            checkUser(login, pass);
            if (login.equals(loginPage.getUsername()) && pass.equals(loginPage.getPass())){
                if(loginPage.getRoot() == 1){
                    jump("/indexAdmin.jsp", request, response);
                }
                jump("/index.jsp", request, response);
            }
        } catch (IllegalArgumentException ex) {
            jumpError("/index.jsp", ex.getMessage(), request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionControl.close();
        }
    }

    private void checkUser(String login, String pass) throws SQLException, ClassNotFoundException {
        Connection connection;
        try {
            connection = ConnectionControl.getConnection();
            loginPage = new DBDataLoader().getUser(connection, login, pass);
        } finally {
            ConnectionControl.close();
        }
    }
}
