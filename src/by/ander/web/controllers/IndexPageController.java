package by.ander.web.controllers;

import by.ander.web.beans.Apartment;
import by.ander.web.db.ConnectionControl;
import by.ander.web.db.DBDataLoader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("serial")
public class IndexPageController extends AbstractBaseController {
    @Override
    protected void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection;
        try {
            connection = ConnectionControl.getConnection();
            DBDataLoader loader = new DBDataLoader();
            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter out = response.getWriter()){
                List<Apartment> apartments = loader.getAllApartments(connection);
                Gson gson = new GsonBuilder()
                        .excludeFieldsWithoutExposeAnnotation()
                        .create();
                out.print(gson.toJson(apartments));
            }
            jump("/index.html", request, response);
        } catch (IllegalArgumentException | SQLException | ClassNotFoundException ex) {
            jumpError("/index.html", ex.getMessage(), request, response);
        } finally {
            ConnectionControl.close();
        }
    }
}
