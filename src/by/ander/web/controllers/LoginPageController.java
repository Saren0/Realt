package by.ander.web.controllers;

import by.ander.web.beans.User;
import by.ander.web.db.ConnectionControl;
import by.ander.web.db.DBDataLoader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class LoginPageController extends AbstractBaseController {
    private User user;

    @Override
    protected void performTask(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String login = request.getParameter("username");
            String pass = request.getParameter("pass");
            checkUser(login, pass);
            if (login.equals(user.getUsername()) && pass.equals(user.getPass())){
                if(user.getRoot() == 1){
                    jump("/admin.jsp", request, response);
                }
                jump("/indexAdmin.jsp", request, response);
            }
        } catch (IllegalArgumentException ex) {
            jumpError("/index.html", ex.getMessage(), request, response);
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
            user = new DBDataLoader().getUser(connection, login, pass);
        } finally {
            ConnectionControl.close();
        }
    }
}
