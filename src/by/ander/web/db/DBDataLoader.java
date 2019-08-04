package by.ander.web.db;

import by.ander.web.beans.Apartment;
import by.ander.web.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс с методами выполнения запросов, согласно заданиям.
 * @author Palachanin Aliaksei
 */
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

    public List<List<String>> getResultsWithDate(Connection connection, String date) throws SQLException {
        final int ID = 1;
        final int O_Z = 2;
        final int INDEX = 3;
        final int AUTHOR = 4;
        final int NAZVANIE = 5;
        final int YEAR = 6;
        final int PRICE = 7;
        final int YEAR_A = 8;
        List<List<String>> result = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    SQLQueries.TASK_1);
            preparedStatement.setString(1, date);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<String> currentList = new ArrayList<>();
                currentList.add(Integer.toString(resultSet.getInt(ID)));
                currentList.add(resultSet.getString(O_Z));
                currentList.add(Integer.toString(resultSet.getInt(INDEX)));
                currentList.add(resultSet.getString(AUTHOR));
                currentList.add(resultSet.getString(NAZVANIE));
                currentList.add(resultSet.getString(YEAR));
                currentList.add(Double.toString(resultSet.getDouble(PRICE)));
                currentList.add(resultSet.getString(YEAR_A));
                result.add(currentList);
            }
            return result;
        } finally {
            ConnectionControl.close(resultSet);
            ConnectionControl.close(preparedStatement);
        }
    }

    public List<List<String>> getAllBooks_OZ(Connection connection, String oz) throws SQLException {
        final int ID = 1;
        final int O_Z = 2;
        final int INDEX = 3;
        final int AUTHOR = 4;
        final int NAZVANIE = 5;
        final int YEAR = 6;
        final int PRICE = 7;
        List<List<String>> result = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    SQLQueries.TASK_2);
            preparedStatement.setString(1, oz);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<String> currentList = new ArrayList<>();
                currentList.add(Integer.toString(resultSet.getInt(ID)));
                currentList.add(resultSet.getString(O_Z));
                currentList.add(Integer.toString(resultSet.getInt(INDEX)));
                currentList.add(resultSet.getString(AUTHOR));
                currentList.add(resultSet.getString(NAZVANIE));
                currentList.add(resultSet.getString(YEAR));
                currentList.add(Double.toString(resultSet.getDouble(PRICE)));
                result.add(currentList);
            }
            return result;
        } finally {
            ConnectionControl.close(resultSet);
            ConnectionControl.close(preparedStatement);
        }
    }

    public List<List<String>> getAllBooksMoreThan(Connection connection, String bookCount) throws SQLException {
        final int ID = 1;
        final int O_Z = 2;
        final int INDEX = 3;
        final int AUTHOR = 4;
        final int NAZVANIE = 5;
        final int YEAR = 6;
        final int PRICE = 7;
        final int COUNT = 8;
        List<List<String>> result = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    SQLQueries.TASK_3);
            preparedStatement.setString(1, bookCount);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<String> currentList = new ArrayList<>();
                currentList.add(Integer.toString(resultSet.getInt(ID)));
                currentList.add(resultSet.getString(O_Z));
                currentList.add(Integer.toString(resultSet.getInt(INDEX)));
                currentList.add(resultSet.getString(AUTHOR));
                currentList.add(resultSet.getString(NAZVANIE));
                currentList.add(resultSet.getString(YEAR));
                currentList.add(Double.toString(resultSet.getDouble(PRICE)));
                currentList.add(Integer.toString(resultSet.getInt(COUNT)));
                result.add(currentList);
            }
            return result;
        } finally {
            ConnectionControl.close(resultSet);
            ConnectionControl.close(preparedStatement);
        }
    }

    public List<List<String>> getAllBooksByNameAndCount(Connection connection, String bookCount, String bookName) throws SQLException {
        final int ID = 1;
        final int O_Z = 2;
        final int INDEX = 3;
        final int AUTHOR = 4;
        final int NAZVANIE = 5;
        final int YEAR = 6;
        final int PRICE = 7;
        final int COUNT = 8;
        List<List<String>> result = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    SQLQueries.TASK_4);
            preparedStatement.setString(1, bookCount);
            preparedStatement.setString(2, bookName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<String> currentList = new ArrayList<>();
                currentList.add(Integer.toString(resultSet.getInt(ID)));
                currentList.add(resultSet.getString(O_Z));
                currentList.add(Integer.toString(resultSet.getInt(INDEX)));
                currentList.add(resultSet.getString(AUTHOR));
                currentList.add(resultSet.getString(NAZVANIE));
                currentList.add(resultSet.getString(YEAR));
                currentList.add(Double.toString(resultSet.getDouble(PRICE)));
                currentList.add(Integer.toString(resultSet.getInt(COUNT)));
                result.add(currentList);
            }
            return result;
        } finally {
            ConnectionControl.close(resultSet);
            ConnectionControl.close(preparedStatement);
        }
    }
}