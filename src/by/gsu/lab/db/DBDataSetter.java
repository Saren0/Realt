package by.gsu.lab.db;

import java.sql.*;

public class DBDataSetter {

	public void insertUser(Connection connection, String login, String password, String root) throws SQLException {
		final int LOGIN = 1;
		final int PASSWORD = 2;
		final int ROOT = 3;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQLQueries.PS_INSERT_USER);
            preparedStatement.setString(LOGIN, login);
            preparedStatement.setString(PASSWORD, password);
            preparedStatement.setString(ROOT, root);
            preparedStatement.executeUpdate();
        } finally {
            ConnectionControl.close(preparedStatement);
        }
	}

	public void insertApartment(Connection connection, String name, String bedroom, String square, String price,
                                String phone, String picture) throws SQLException{
		final int NAME = 1;
		final int BEDROOM = 2;
		final int SQUARE = 3;
		final int PRICE = 4;
        final int PHONE = 5;
        final int PICTURE = 6;
        PreparedStatement psInsertDots = null;
        try {
            psInsertDots = connection.prepareStatement(
                    SQLQueries.PS_INSERT_APARTMENT);
            psInsertDots.setString(NAME, name);
            psInsertDots.setString(BEDROOM, bedroom);
            psInsertDots.setString(SQUARE, square);
            psInsertDots.setString(PRICE, price);
            psInsertDots.setString(PHONE, phone);
            psInsertDots.setString(PICTURE, picture);
            psInsertDots.executeUpdate();
        } finally {
            ConnectionControl.close(psInsertDots);
        }	
	}
}
