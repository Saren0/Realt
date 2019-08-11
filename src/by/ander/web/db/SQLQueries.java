package by.ander.web.db;

class SQLQueries {
    final static String GET_USER =
            "SELECT * FROM realt.users WHERE login = ? AND pass = ?;";

    final static String GET_ALL_USERS =
            "SELECT * FROM realt.users;";

    final static String GET_ALL_APARTMENTS =
            "SELECT * FROM realt.apartments;";

    final static String PS_INSERT_USER =
            "INSERT INTO realt.users (login, pass, root) VALUES (?, ?, ?);";

    final static String PS_INSERT_APARTMENT =
            "INSERT INTO realt.apartments (name, bedrooms, square, price, phone, picture) VALUES (?, ?, ?, ?, ?, ?);";
}