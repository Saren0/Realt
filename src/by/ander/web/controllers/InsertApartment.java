package by.ander.web.controllers;

import by.ander.web.db.ConnectionControl;
import by.ander.web.db.DBDataSetter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;


@SuppressWarnings("serial")
@MultipartConfig
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
            Part filePart = request.getPart("File");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            InputStream fileContent = filePart.getInputStream();

            final String PATH = "C:\\Users\\user\\Downloads\\Realt\\WebContent\\upload";
            String picturePath = PATH + File.separator + fileName;
            insertPictureIntoServer(fileContent, picturePath);

            doInsertApartment(name, bedroom, square, price, phone, picturePath);
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

    private void insertPictureIntoServer(InputStream input, String path) throws IOException {
        try (OutputStream out = new FileOutputStream(new File(path))) {
            int read;
            final byte[] bytes = new byte[1024];

            while ((read = input.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
}
