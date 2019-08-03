package by.gsu.lab.db;

/**
 * @author Palachanin Aliaksei
 */
class DBConstants {

    // The source data for the connection to the database.

    /**
     * Класс драйвера mysql
     */
    final static String DB_CLASS = "com.mysql.cj.jdbc.Driver";

    /**
     * URL базы данных. Состоит из сервера (localhost), порта (3306) и
     * имени базы данных (dots)
     */
    final static String DB_URL =
            "jdbc:mysql://localhost:3306/realt?useLegacyDatetimeCode=false&amp&serverTimezone=UTC";

    /**
     * Пользователь
     */
    final static String DB_LOGIN = "root";

    /**
     * Пароль
     */
    final static String DB_PASSWORD = "";
}