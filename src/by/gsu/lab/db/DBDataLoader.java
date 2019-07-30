package by.gsu.lab.db;

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

    public List<List<String>> getAllBooks(Connection connection) throws SQLException {
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
                    SQLQueries.PS_SELECT_BOOKS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<String> currentList = new ArrayList<>();
                currentList.add(Integer.toString(resultSet.getInt(ID)));
                currentList.add(resultSet.getString(O_Z));
                currentList.add(Integer.toString(resultSet.getInt(INDEX)));
                currentList.add(resultSet.getString(AUTHOR));
                currentList.add(resultSet.getString(NAZVANIE));
                currentList.add(Integer.toString(resultSet.getInt(YEAR)));
                currentList.add(Double.toString(resultSet.getDouble(PRICE)));
                result.add(currentList);
            }
            return result;
        } finally {
            ConnectionControl.close(resultSet);
            ConnectionControl.close(preparedStatement);
        }
    }

    public List<List<String>> getAllArrivales(Connection connection) throws SQLException {
        final int ID = 1;
        final int O_Z = 2;
        final int INDEX = 3;
        final int KOLVO = 4;
        final int DATE_POSTYP = 5;
        List<List<String>> result = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    SQLQueries.PS_SELECT_ARRIVALES);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<String> currentList = new ArrayList<>();
                currentList.add(Integer.toString(resultSet.getInt(ID)));
                currentList.add(resultSet.getString(O_Z));
                currentList.add(Integer.toString(resultSet.getInt(INDEX)));
                currentList.add(Integer.toString(resultSet.getInt(KOLVO)));
                currentList.add(resultSet.getString(DATE_POSTYP));
                result.add(currentList);
            }
            return result;
        } finally {
            ConnectionControl.close(resultSet);
            ConnectionControl.close(preparedStatement);
        }
    }

    public List<List<String>> getAllSells(Connection connection) throws SQLException {
        final int ID = 1;
        final int O_Z = 2;
        final int INDEX = 3;
        final int KOLVO = 4;
        final int PRICE = 5;
        final int DATE = 6;
        List<List<String>> result = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    SQLQueries.PS_SELECT_SELLS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<String> currentList = new ArrayList<>();
                currentList.add(Integer.toString(resultSet.getInt(ID)));
                currentList.add(resultSet.getString(O_Z));
                currentList.add(Integer.toString(resultSet.getInt(INDEX)));
                currentList.add(Integer.toString(resultSet.getInt(KOLVO)));
                currentList.add(Double.toString(resultSet.getDouble(PRICE)));
                currentList.add(resultSet.getString(DATE));
                result.add(currentList);
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