package by.gsu.lab.db;

/**
 * SQL-запросы
 * @author Palachanin Aliaksei
 */
class SQLQueries {

    final static String GET_USERS =
            "SELECT * FROM users WHERE login = ? AND password = ?;";

    final static String PS_INSERT_BOOKS =
            "INSERT INTO shop.books (obl_znani, index_k, author, nazvanie, year_book, price) VALUES (?, ?, ?, ?, ?, ?);";

    final static String PS_INSERT_ARRIVE =
            "INSERT INTO shop.arrival (obl_znani, index_k, kolich, arrival_date) VALUES (?, ?, ?, ?);";

    final static String PS_INSERT_SELLS =
            "INSERT INTO shop.sells (obl_znani, index_k, kolich, otpysk_price, sell_date) VALUES (?, ?, ?, ?, ?);";

    final static String PS_SELECT_BOOKS =
            "SELECT * FROM shop.books;";

    final static String PS_SELECT_ARRIVALES =
            "SELECT * FROM shop.arrival;";

    final static String PS_SELECT_SELLS =
            "SELECT * FROM shop.sells;";

    final static String TASK_1 =
            "SELECT books.*, arrival.arrival_date FROM shop.books, shop.arrival WHERE books.index_k = arrival.index_k AND arrival_date = ?";

    final static String TASK_2 =
            "SELECT * FROM shop.books WHERE obl_znani = ?";

    final static String TASK_3 =
            "SELECT books.*, sells.kolich FROM shop.books, shop.sells WHERE books.index_k = sells.index_k AND kolich > ?;";

    final static String TASK_4 =
            "SELECT books.*, sells.kolich FROM shop.books, shop.sells WHERE books.index_k = sells.index_k AND kolich = ? AND nazvanie = ?;";
}