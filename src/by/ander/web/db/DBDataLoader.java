package by.ander.web.db;

import by.ander.web.beans.Apartment;
import by.ander.web.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBDataLoader {

    public User getUser(Connection connection, String login, String password)
            throws SQLException{
        final int ID = 1;
        final int LOGIN = 2;
        final int PASSWORD = 3;
        final int ROOTS = 4;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(
                    SQLQueries.GET_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = new User(resultSet.getInt(ID),
                        resultSet.getString(LOGIN),
                        resultSet.getString(PASSWORD),
                        resultSet.getInt(ROOTS));
            }
            return user;
        } finally {
            ConnectionControl.close(resultSet);
            ConnectionControl.close(preparedStatement);
        }
    }

    public List<User> getAllUsers(Connection connection)
            throws SQLException{
        final int ID = 1;
        final int LOGIN = 2;
        final int PASSWORD = 3;
        final int ROOTS = 4;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> result = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(
                    SQLQueries.GET_ALL_USERS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result.add(new User(resultSet.getInt(ID),
                        resultSet.getString(LOGIN),
                        resultSet.getString(PASSWORD),
                        resultSet.getInt(ROOTS)));
            }
            return result;
        } finally {
            ConnectionControl.close(resultSet);
            ConnectionControl.close(preparedStatement);
        }
    }

    public List<Apartment> getAllApartments(Connection connection)
            throws SQLException{
        final int ID = 1;
        final int NAME = 2;
        final int BEDROOM = 3;
        final int SQUARE = 4;
        final int PRICE = 5;
        final int PHONE = 6;
        final int PICTURE = 7;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Apartment> result = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(
                    SQLQueries.GET_ALL_APARTMENTS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result.add(new Apartment(resultSet.getInt(ID),
                        resultSet.getString(NAME),
                        resultSet.getInt(BEDROOM),
                        resultSet.getDouble(SQUARE),
                        resultSet.getBigDecimal(PRICE),
                        resultSet.getInt(PHONE),
                        resultSet.getString(PICTURE)));
            }
            return result;
        } finally {
            ConnectionControl.close(resultSet);
            ConnectionControl.close(preparedStatement);
        }
    }
}