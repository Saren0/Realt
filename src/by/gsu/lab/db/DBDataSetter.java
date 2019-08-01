package by.gsu.lab.db;

import java.sql.*;

/**
 * 
 * @author Palachanin Aliaksei
 */
public class DBDataSetter {

    public void getUsers(Connection connection, String login, String password)
            throws SQLException{
        final int LOGIN = 1;
        final int PASSWORD = 2;

        PreparedStatement credentials = null;
        try {
            credentials = connection.prepareStatement(
                    SQLQueries.GET_USERS);
            credentials.setString(LOGIN, login);
            credentials.setString(PASSWORD, password);
            credentials.executeUpdate();
        } finally {
            ConnectionControl.close(credentials);
        }
    }

	public void insertBooks(Connection connection, String a, String b, String c, String d, String e, String f)
		throws SQLException {		
		final int INDEX_X = 1;
		final int INDEX_Y = 2;
		final int INDEX_XX = 3;
		final int INDEX_YY = 4;
		final int INDEX_XXX = 5;
		final int INDEX_YYY = 6;
        PreparedStatement psInsertDots = null;
        try {
            psInsertDots = connection.prepareStatement(
                    SQLQueries.PS_INSERT_BOOKS);
            psInsertDots.setString(INDEX_X, a);
            psInsertDots.setString(INDEX_Y, b);
            psInsertDots.setString(INDEX_XX, c);
            psInsertDots.setString(INDEX_YY, d);
            psInsertDots.setString(INDEX_XXX, e);
            psInsertDots.setString(INDEX_YYY, f);
            psInsertDots.executeUpdate();
        } finally {
            ConnectionControl.close(psInsertDots);
        }
	}

	public void insertArrive(Connection connection, String a, String b, String c, String d) 
		throws SQLException{		
		final int INDEX_X = 1;
		final int INDEX_Y = 2;
		final int INDEX_XX = 3;
		final int INDEX_YY = 4;
        PreparedStatement psInsertDots = null;
        try {
            psInsertDots = connection.prepareStatement(
                    SQLQueries.PS_INSERT_ARRIVE);
            psInsertDots.setString(INDEX_X, a);
            psInsertDots.setString(INDEX_Y, b);
            psInsertDots.setString(INDEX_XX, c);
            psInsertDots.setString(INDEX_YY, d);
            psInsertDots.executeUpdate();
        } finally {
            ConnectionControl.close(psInsertDots);
        }	
	}

	public void insertSells(Connection connection, String a, String b, String c, String d, String e) 
			throws SQLException{		
		final int INDEX_X = 1;
		final int INDEX_Y = 2;
		final int INDEX_XX = 3;
		final int INDEX_YY = 4;
		final int INDEX_XXX = 5;
        PreparedStatement psInsertDots = null;
        try {
            psInsertDots = connection.prepareStatement(
                    SQLQueries.PS_INSERT_SELLS);
            psInsertDots.setString(INDEX_X, a);
            psInsertDots.setString(INDEX_Y, b);
            psInsertDots.setString(INDEX_XX, c);
            psInsertDots.setString(INDEX_YY, d);
            psInsertDots.setString(INDEX_XXX, e);
            psInsertDots.executeUpdate();
        } finally {
            ConnectionControl.close(psInsertDots);
        }			
	}
}
